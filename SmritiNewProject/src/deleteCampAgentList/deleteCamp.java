package deleteCampAgentList;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class deleteCamp {
	
	 private WebDriver driver;
	 private String baseUrl;
	 private StringBuffer verificationErrors = new StringBuffer();
	@Before
	  public void setUp() throws Exception {
		  
			System.setProperty("webdriver.gecko.driver", "F:/gecko/geckodriver.exe");
	    driver = new FirefoxDriver();
	    baseUrl = "http://192.168.1.57/";
	    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	  }
	 @Test
	 public void campaign_deletion1() throws Exception {
		    driver.get(baseUrl);
		    driver.findElement(By.name("pwd")).clear();
		    driver.findElement(By.name("pwd")).sendKeys("rwpass");
		    driver.findElement(By.name("uid")).clear();
		    driver.findElement(By.name("uid")).sendKeys("adminrw");
		    driver.findElement(By.name("Submit")).click();
		    driver.findElement(By.name("login_existing_agent")).click();
		    //driver.findElement(By.cssSelector("div > img")).click();
		    Thread.sleep(3000);
		    //driver.wait(2000);  
		    
		     driver.findElement(By.xpath("html/body/table/tbody/tr/td[2]/div/img")).click();
		           System.out.println("move to admin panal");
		    //driver.findElement(By.linkText("Call Center")).click();
		    driver.findElement(By.xpath("html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[3]/a")).click();
		    System.out.println("click on call center");
		    Thread.sleep(20000);
		    driver.findElement(By.id("Campaigns_li_a")).click();
		    System.out.println("click on campaign");
			driver.findElement(By.linkText("Call Center")).click();
		    driver.findElement(By.id("Campaigns_li_a")).click();
		    driver.findElement(By.name("campaign_d[50#adasd]")).click();
		    driver.findElement(By.name("campaign_delete[50]")).click();
    
			    /*if( isAlertPresent()){
				assertEquals("Are you sure, you want to delete Campaign - adasd!", closeAlertAndGetItsText());
			    }*/
       }
			 @After
			  public void tearDown() throws Exception {
			    //driver.quit();
			    String verificationErrorString = verificationErrors.toString();
			    if (!"".equals(verificationErrorString)) {
			      fail(verificationErrorString);
			    }
			  }
}
