package Login;

import dataBaseConnection.Dbconnection;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
public class LogInCredential extends Dbconnection{
	public static String camp_state;
	public static String camp_id;
	public static String camp_name;
	public static String list_id1;
	public static WebDriver driver;


	//Constructor
	public LogInCredential() throws Exception  {
		super();
		this.driver = driver;
		
	}
	
	public static void LogIn() throws Exception {
		
		System.out.println("in login crendential");
		
		/*----------------for firefox-----------------*/
		System.setProperty("webdriver.gecko.driver", "F:/gecko/geckodriver.exe");
	    FirefoxDriver driver = new FirefoxDriver();	
	    
	    
	    
	    
	    /*----------------for IE browser--------------*/
	    //System.setProperty("webdriver.ie.driver", "C:/Users/TVT/Desktop/DESKTOP/smriti/Selenium_Libs/selenium_libs/IEDriverServer_Win32_2.37.0/IEDriverServer.exe");
	    //driver = new InternetExplorerDriver();	
	    
	    /*------------------for CHROME browser---------*/
		//System.setProperty("webdriver.chrome.driver", "C:/Users/TVT/Desktop/DESKTOP/smriti/Selenium_Libs/selenium_libs/chromedriver_win32/chromedriver.exe");
	   //driver = new ChromeDriver();
	    
	    
	    String baseUrl = "http://192.168.1.57/";
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
	      if(getValue()>0){
	    		
	    	   System.out.println("already logged in");
	    	   driver.findElement(By.name("login_existing_agent")).click();
	    	   System.out.println("click on yes");
	    	   Thread.sleep(1000);
	    	   driver.findElement(By.xpath("html/body/table/tbody/tr/td[2]/div/img")).click();
	    	   System.out.println("click on move to admin panal");
	    	   String display_username = (driver.findElement(By.xpath("//*[@id='welcome']/div[2]/strong")).getText()).trim();
	   		 System.out.println(display_username);
	   		boolean isLoggedin ;
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
	
	
}
