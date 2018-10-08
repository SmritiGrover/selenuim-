package AgentCalling;


import java.io.*;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.junit.Test;

public class Agent_login{

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	PrintStream imageFileOutputStream;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "F:/gecko/geckodriver.exe");
		driver = new FirefoxDriver();
		System.out.println("opening browser");
		baseUrl = "http://172.16.1.215/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void agent_login1() throws Exception {
		Thread.sleep(10000);
		driver.get(baseUrl + "agentui.php");			 
		driver.findElement(By.name("agent_id")).clear();
		driver.findElement(By.name("agent_id")).sendKeys("2001");		
		if(isElementPresent(By.xpath(
				"html/body/form[2]/table[2]/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr/td/input" ))){
					driver.findElement(By.xpath(
					        "html/body/form[2]/table[2]/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr/td/input"
						  )).click();
				}
		System.out.println("before login");
		
		//Ready the agent
		if(isElementPresent(By.id("takeBreak"))){
			driver.findElement(By.id("takeBreak")).click();
			System.out.println("click on ready button");
		}

		  Thread.sleep(2000);
		  System.out.println("before crm");
		  driver.switchTo().frame(driver.findElement(By.name("crm")));
		  Thread.sleep(20000);
		
		  //BREAK AND BACK
		 if( isElementPresent(By.xpath("//*[@id='takeBreak']")))
		 {
			 
			  driver.findElement(By.xpath("//*[@id='takeBreak']")).click();	
			  System.out.println("click on break");
			  Thread.sleep(2000);
			  driver.findElement(By.id("backBreak")).click();	
			  System.out.println("Back from break");
		 }
		  System.out.println("after crm");
		 
		  //Refreshing the page
		  driver.navigate().refresh();
		  System.out.println("refresh the page");
		  Thread.sleep(2000);
		  
		  
		  if(isElementPresent(By.xpath("//*[@id='progressiveMode']")))
		  {System.out.println("=============");
		  driver.findElement(By.xpath("//*[@id='progressiveMode']")).click();
		  System.out.println("click on progressive");
		  }
		  Thread.sleep(10000);
		  
		  //Make a new call
		  if(isElementPresent(By.xpath("//*[@name='makeNewCall']"))){
			  driver.findElement(By.xpath("//*[@name='makeNewCall']")).click();	
			  System.out.println("make a new call");
			  Thread.sleep(10000);
			  isElementPresent(By.id("phone1"));
			  driver.findElement(By.id("phone1")).clear();
			  driver.findElement(By.id("phone1")).sendKeys("23432421");
			  isElementPresent(By.name("manualDial"));
			  driver.findElement(By.name("manualDial")).click();
			  System.out.println("dial a num");
			  
		  }
		 
	      //Refreshing the page
	      Thread.sleep(10000);
	      driver.navigate().refresh();
	      System.out.println("refresh");
	      Thread.sleep(10000);
	
	      //Add customer  
	      if(isElementPresent(By.xpath(("//input[@value='Add Customer' and @type='submit']")))){
	    	  
	    	  driver.findElement(By.xpath("//input[@value='Add Customer' and @type='submit']")).click();
			  System.out.println("click on Add customer");
			  Thread.sleep(1000); 
			  assertTrue(closeAlertAndGetItsText().matches( "^Are you sure you want to create a Lead[\\s\\S]$"));
			  Thread.sleep(1000);
	      }
	      else{
    	    System.out.println("add customer not visible");
	    	//Call take screenshot function
	          this.takeSnapShot(driver, "F://addcustmer.png") ; 
	    	  System.out.println("capture screen short");
	      }
	      
		  //scroll down
          JavascriptExecutor js = ((JavascriptExecutor) driver);
          js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
		  System.out.println("scroll down");
		  
		  //Enter comment
		  if(isElementPresent(By.xpath("html/body/form/table[8]/tbody/tr[1]/td[2]/span/textarea"))){
			  driver.findElement(By.xpath("html/body/form/table[8]/tbody/tr[1]/td[2]/span/textarea")).clear();
			  driver.findElement(By.name("txt")).sendKeys("test");
			  driver.findElement(By.xpath("html/body/form/table[8]/tbody/tr[1]/td[2]/span/textarea")).sendKeys("test");
			  Thread.sleep(2000);
		  }
		  
		  //Select Disposition 
		  
		// new Select(driver.findElement(By.id("custDisposition"))).selectByVisibleText("aaaa");
		// driver.findElement(By.xpath("//*[@id='save']")).click();
		
		 if(isElementPresent(By.xpath("//*[@id='save']"))){
			 driver.findElement(By.xpath("//*[@id='save']")).click();
			 System.out.println("click on disconnect button");
			 Thread.sleep(10000); 
		 }
		 
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	} 

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
           //funtion for taking screeenshort
	public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot
           TakesScreenshot scrShot =((TakesScreenshot)webdriver);
           System.out.println("Convert web driver object to TakeScreenshot");
        //Call getScreenshotAs method to create image file
                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
              System.out.println("Call getScreenshotAs method to create image file");
            //Move image file to new destination
                File DestFile=new File(fileWithPath);
              System.out.println("Move image file to new destination");
                //Copy file at destination
                FileUtils.copyFile(SrcFile, DestFile);
              System.out.println("Copy file at destination");
    }
	//funtion of accepting alert
	public String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				
				alert.accept();
			} 
			
			else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
