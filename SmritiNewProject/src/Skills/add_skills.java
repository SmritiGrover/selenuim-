package Skills;


import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.FluentWait;

import dataBaseConnection.Dbconnection;
public class add_skills extends Dbconnection{
	public add_skills() throws SQLException {
		super();
		
	}
	  private WebDriver driver;
	  private String baseUrl;
	  public static boolean isLoggedin = false;
	 // private boolean acceptNextAlert = true;
	  @Before
	  public void setUp() throws Exception {	  
			System.setProperty("webdriver.gecko.driver", "F:/gecko/geckodriver.exe");
	    driver = new FirefoxDriver();
	    baseUrl = "http://192.168.1.100/";
	    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	  }
	  @Test
	  public void skills1() throws Exception {
	    driver.get(baseUrl);
	    /*-------------LOGIN-------------*/
	    driver.findElement(By.name("uid")).clear();
	    driver.findElement(By.name("uid")).sendKeys("adminrw");
	    System.out.println("insert Username");
	    driver.findElement(By.name("pwd")).clear();
	    //driver.findElement(By.name("pwd")).sendKeys("ready@123");
	    driver.findElement(By.name("pwd")).sendKeys("rwpass");
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
	    driver.findElement(By.id("Campaigns_li_a")).click();
	    System.out.println("click on campaign");
	        System.out.println(camp_id);
			driver.findElement(By.name("add_skills["+camp_id+"]")).click();
		    driver.findElement(By.id("skill_name")).clear();
		    driver.findElement(By.id("skill_name")).sendKeys("hindi");
		    driver.findElement(By.id("max_queue_len")).clear();
		    driver.findElement(By.id("max_queue_len")).sendKeys("10");
		    driver.findElement(By.id("add_skill_set")).click();
		    Thread.sleep(10000L);
		    driver.findElement(By.id("skill_name")).clear();
		    driver.findElement(By.id("skill_name")).sendKeys("english");
		    driver.findElement(By.id("max_queue_len")).clear();
		    driver.findElement(By.id("max_queue_len")).sendKeys("10");
		    driver.findElement(By.id("radio2")).click();
		    driver.findElement(By.id("radio1")).click();
		    driver.findElement(By.id("skill_name")).clear();
		    driver.findElement(By.id("skill_name")).sendKeys("english");
		    driver.findElement(By.id("add_skill_set")).click();
		    Thread.sleep(10000L);
		    driver.findElement(By.id("radio2")).click();
		    Thread.sleep(10000L);
		    driver.findElement(By.name("assign_camp_agent_skills[1]")).click();
		    Thread.sleep(10000);
		    driver.findElement(By.id("assign_camp_skill_to_agent")).click();
		    
		    
		    //Create object of FluentWait class and pass webdriver as input
		    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		    // It should poll webelement after every single second
			wait.pollingEvery(250, TimeUnit.MILLISECONDS);
			 // Max time for wait- If conditions are not met within this time frame then it will fail the script
			wait.withTimeout(2, TimeUnit.MINUTES);
			wait.ignoring(NoSuchElementException.class);
		   
		    
 }
	 
	  
}
