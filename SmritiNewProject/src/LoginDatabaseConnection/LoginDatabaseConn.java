package LoginDatabaseConnection;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;


	/**
	* @author Smriti
	* 
	* 
	* This class will store all the locator and methods of login page
	*
	*/
	public class LoginDatabaseConn {

		public static WebDriver driver;
		public static String baseUrl;
		public verifierMultiverfier.VerfierMulti VerfierMulti;
		
		public static EventFiringWebDriver dr = null;
		public static boolean isLoggedin = false;
		//public static Xls_Reader dt = null;
		
		/* ---------------Database Connection--------------------*/
		public static Connection conn = null;
		public static PreparedStatement pstmt = null;
		public static ResultSet rs = null;
		public static int test = 0;
		public static String camp_state;
		public static String camp_id;
		public static String camp_name;
		public static String list_id1;
		
		static String  testEnv;
		//create user 'smriti'@'localhost' identified by 'smritiPWD';
		//Use this command into database:GRANT ALL PRIVILEGES ON czentrix_campaign_manager.* TO 'smriti'@'192.168.1.57' identified by 'smritiPWD';
		
		public static String url= "jdbc:mysql://192.168.1.57/czentrix_campaign_manager";
			
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		public static String db_driver = "com.mysql.jdbc.Driver";
		public static String db_un = "cz_user";
		public static String db_pw = "password";
		/* --------------------------------------------------------*/
		//Constructor
				public LoginDatabaseConn(WebDriver driver) {	
					System.out.println("in");
					this.driver = driver;
				}
		
		// Method-1.
		@Before

				public void beforeTest() throws IOException {
				  System.out.println("in before");
				  db_connection();
				} 
		public static void db_connection() {
			try{
				System.out.println("come in database conection funtion");
				//Load mysql jdbc driver
				Class.forName(db_driver).newInstance();
				System.out.println(Class.forName(db_driver).newInstance());
				
				//Create Connection to DB
				conn = DriverManager.getConnection(url,db_un,db_pw);
				System.out.println("connection establish with " + conn);
				
				if(conn!=null) {
	                System.out.println("Connected to the database");
	            }else {
	                System.out.println("Failed to connect to "+testEnv+" database");
	            }
				//Query to Execute	
				String query = "select * from logged_in_users where user_name = 'adminrw'";
				String query1 = "select * from campaign where campaign_name='smriti_in'";
				
				
				//Create Statement Object			  
				Statement stmt = conn.createStatement();
		
				// Execute the SQL Query. Store results in ResultSet		
					ResultSet rs= stmt.executeQuery(query);	
				
					System.out.println(query);
					System.out.println(rs.getRow()  +"--------");
				 // While Loop to iterate through all data and print results		
				while (rs.next()){
					System.out.println("coming in while");
			        		String user_id = rs.getString(1);								        
			                String user_name = rs.getString(2);
			                String first_name  = rs.getString(3);
			                String last_name = rs.getString(4);								        
			                String login_time = rs.getString(5);
			                String ip  = rs.getString(6);
			        		String last_login_time = rs.getString(7);								        
			                String last_activity_time = rs.getString(8);
			                String session_id  = rs.getString(9);
			                String last_updated  = rs.getString(10);
			                System. out.println(user_id+"  "+user_name+ "   "+session_id);	
			                test++;
			        }
				ResultSet rs1= stmt.executeQuery(query1);
				while (rs1.next()){
	        		String campaign_id = rs1.getString(1);								        
	                String campaign_name = rs1.getString(2);
	                String campaign_state  = rs1.getString(3);
	                System.out.println(campaign_id+"  "+campaign_name+" "+campaign_state);
	                 camp_id = campaign_id;
	                 camp_name = campaign_name;
	                camp_state = campaign_state;
	               
	        }
				String query2 ="select * from list where list_name = 'smriti_list'";
				System.out.println(query2);
				ResultSet rs2= stmt.executeQuery(query2);
				while(rs2.next()){
					String list_id = rs2.getString(1);								        
	                String list_name = rs2.getString(2);
	                String list_state  = rs2.getString(3);
	                String campaign_id  = rs2.getString(3);
	                System.out.println(list_id);
	                list_id1 =  list_id;
	                System.out.println(list_id1+"    list id");
				}
				
				/*================for dialer=============*/
				//update campaign set disable_lead_state = '1' where campaign_id='31'
				//Call the set up class
				setUp();
				
				
			}catch(Exception e){
				System.out.println(e);
			  }
			}
			
		
		public static void setUp() throws Exception {
			System.out.println("in Test Base");
			
			/*----------------for firefox-----------------*/
			System.setProperty("webdriver.gecko.driver", "F:/gecko/geckodriver.exe");
		    driver = new FirefoxDriver();	
		    
		    
		    /*----------------for IE browser--------------*/
		    //System.setProperty("webdriver.ie.driver", "C:/Users/TVT/Desktop/DESKTOP/smriti/Selenium_Libs/selenium_libs/IEDriverServer_Win32_2.37.0/IEDriverServer.exe");
		    //driver = new InternetExplorerDriver();	
		    
		    /*------------------for CHROME browser---------*/
			//System.setProperty("webdriver.chrome.driver", "C:/Users/TVT/Desktop/DESKTOP/smriti/Selenium_Libs/selenium_libs/chromedriver_win32/chromedriver.exe");
		   //driver = new ChromeDriver();
		    
		    
		    baseUrl = "http://192.168.1.57/";
		    driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
		    driver.get(baseUrl);  
		    
			  
		    /*-------------LOGIN-------------*/
		    driver.findElement(By.name("uid")).clear();
		    driver.findElement(By.name("uid")).sendKeys("vipin");
		    System.out.println("insert Username");
		    driver.findElement(By.name("pwd")).clear();
		    //driver.findElement(By.name("pwd")).sendKeys("ready@123");
		    driver.findElement(By.name("pwd")).sendKeys("vipin@123");
		    System.out.println("insert password");
		    driver.findElement(By.name("Submit")).click();
		       System.out.println("click on submit");
		       
		       Thread.sleep(1000);
	     
	        //if(driver.findElement(By.xpath("//*[@id='middleTd']/table/tbody/tr[1]/td/img")).isEnabled()){
		      if(test>0){
		    	   System.out.println("already logged in");
		    	   driver.findElement(By.name("login_existing_agent")).click();
		    	   System.out.println("click on yes");
		    	   Thread.sleep(1000);
		    	   driver.findElement(By.xpath("html/body/table/tbody/tr/td[2]/div/img")).click();
		    	   System.out.println("click on move to admin panal");
		    	   String display_username = (driver.findElement(By.xpath("//*[@id='welcome']/div[2]/strong")).getText()).trim();
		   		 System.out.println(display_username);
		   		try {
		   			System.out.println("in try block");
		   			if(display_username.equals("adminrw")){
		   				System.out.println("adminrw");
		   				isLoggedin = true;
		   				
		   				
		   			}else{
		   				System.out.println("jhghjgjhg");
		   				isLoggedin = false;
		   				
		   			}
		   		}catch(Throwable t){
		   		
		   			isLoggedin = false;
		   			
		   		}
		    
		    }
	        else{
		    	System.out.println("new login");
		    	driver.findElement(By.xpath("html/body/table/tbody/tr/td[2]/div/img")).click();	    	
		    	System.out.println("directly logged in and moved to admin panal");
	        }	    
			Thread.sleep(2000L);
	    
		           System.out.println("move to admin panal");
		    //driver.findElement(By.linkText("Call Center")).click();
		    driver.findElement(By.xpath("html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[3]/a")).click();
		    System.out.println("click on call center");
		    Thread.sleep(1000L);
		    
		    //Create object of FluentWait class and pass webdriver as input
		    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		    // It should poll webelement after every single second
			wait.pollingEvery(250, TimeUnit.MILLISECONDS);
			 // Max time for wait- If conditions are not met within this time frame then it will fail the script
			wait.withTimeout(2, TimeUnit.MINUTES);
			wait.ignoring(NoSuchElementException.class);
		  }
		
		// Method-2.
		/*@After
		public void tearDown() throws Exception {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
			//driver.findElement(By.linkText("Logout")).click();
			Thread.sleep(10000);
			//driver.quit();

		}*/
	
}
