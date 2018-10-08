package deleteCampAgentList;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class deleteAgent {
	 private WebDriver driver;
	 private String baseUrl;
	 private StringBuffer verificationErrors = new StringBuffer();
	@Before
	  public void setUp() throws Exception {
		  
			System.setProperty("webdriver.gecko.driver", "F:/gecko/geckodriver.exe");
	    driver = new FirefoxDriver();
	    baseUrl = "http://192.168.1.203/";
	    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	  }
	 @Test
	 public void campaign_deletion1() throws Exception {
	driver.get(baseUrl + "/adminui.php?sipchannel=U0lQIENoYW5uZWwgQ29uZmlndXJhdGlvbg==");
    driver.findElement(By.linkText("Call Center")).click();
    driver.findElement(By.name("pwd")).clear();
    driver.findElement(By.name("pwd")).sendKeys("rwpass");
    driver.findElement(By.name("uid")).clear();
    driver.findElement(By.name("uid")).sendKeys("adminrw");
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.name("login_existing_agent")).click();
    
    //Delete Agent
    
    driver.findElement(By.id("Agents_li_a")).click();
    driver.findElement(By.name("agent_delete[31113]")).click();
    assertEquals("Are you sure, you want to delete Agent - simmi!", closeAlertAndGetItsText());
    
    //Delete List
    driver.findElement(By.id("Lists_li_a")).click();
    driver.findElement(By.cssSelector("div > img")).click();
    driver.findElement(By.linkText("Call Center")).click();
    driver.findElement(By.id("Campaigns_li_a")).click();
    driver.findElement(By.name("list_delete[5]")).click();
    assertEquals("Are you sure, you want to delete List - smriti_new_list2 . This list is assigned to Campaign - smriti_in!", closeAlertAndGetItsText());
    driver.findElement(By.name("campaign_d[50#adasd]")).click();
    driver.findElement(By.name("campaign_delete[50]")).click();
}
	 @After
	  public void tearDown() throws Exception {
	    //driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	 public String closeAlertAndGetItsText() throws InterruptedException {
		    boolean acceptNextAlert = false;
			try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      System.out.println(alert.getText());
		      if (acceptNextAlert) {
		    	  Thread.sleep(1000);
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		    	System.out.println("accepting alert");
		      acceptNextAlert = true;
		    }
	  } 
}

