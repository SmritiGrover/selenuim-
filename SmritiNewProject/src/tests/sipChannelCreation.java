package tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
public class sipChannelCreation extends HomePage{

	public sipChannelCreation(WebDriver driver) {
		super(driver);
		
	}
    @Before
    
	@Test
	  public void sipChann() throws Exception {
	    System.out.println("in sip channel test case");
	    Thread.sleep(1000);
	    /*driver.findElement(By.name("campaign_edit_ui[13]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.name("edit_campaign")).click();
	    Thread.sleep(1000);*/
	    driver.findElement(By.linkText("SIP Channels")).click();
	    //driver.findElement(By.xpath("html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[2]/a")).click();
	    System.out.println("click on sip channel link");
	    Thread.sleep(2000);
	    driver.findElement(By.id("SIPChannelConfiguration_li_a")).click();
	    System.out.println("click on sip channel configuration");
	    Thread.sleep(2000);
	    driver.findElement(By.id("add_ui")).click();
	    System.out.println("click on assign sip channel");
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.id("combosipcamp"))).selectByVisibleText("smriti_in");
	    System.out.println("select campaign");
	    Thread.sleep(2000);
	   // driver.findElement(By.cssSelector("#combosipcamp > option[value=\"31\"]")).click();
	    //System.out.println("click on combobox");
	   // Thread.sleep(2000);
	    new Select(driver.findElement(By.id("combosipcamp1"))).selectByVisibleText("server203");
	    System.out.println("select server");
	    Thread.sleep(2000);
	   // driver.findElement(By.name("moveAllLeft")).click();
	    //System.out.println("move all left");
	    //Thread.sleep(1000);
	    //driver.findElement(By.cssSelector("option[value=\"server203\"]")).click();
	   // System.out.println("select channel");
	   // driver.findElement(By.name("moveSelectedRight")).click();
	    //Thread.sleep(2000);
	    //System.out.println("move selected  right");
	    driver.findElement(By.name("campSip")).click();
	    System.out.println("click on assign button");
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("Call Center")).click();
	    //Create object of FluentWait class and pass webdriver as input
	    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	    // It should poll webelement after every single second
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		 // Max time for wait- If conditions are not met within this time frame then it will fail the script
		wait.withTimeout(2, TimeUnit.MINUTES);
		wait.ignoring(NoSuchElementException.class);
	  }

}
