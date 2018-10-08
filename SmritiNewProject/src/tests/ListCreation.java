package tests;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ListCreation extends HomePage{
		
		public ListCreation(WebDriver driver) {
		super(driver);
	}
		  @Test
		  public void List_creation1() throws Exception  {
		System.out.println("in list creation test case");
		Thread.sleep(1000);
		//driver.findElement(By.xpath("html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[3]/a")).click();
	    driver.findElement(By.id("Campaigns_li_a")).click();
	    System.out.println("Click on campaign");
	    //System.out.println(camp_state);
	    System.out.println(camp_state.toString());
	    System.out.println(camp_id);
	   
	    Thread.sleep(1000);
	    //if (driver.findElement(By.xpath("//input[@value='Deactivate' and @type='submit']")).isDisplayed()){
	    if (TestBase.camp_state.toString() != "ACTIVE"){    	
	    	System.out.println("in  if condition");	
	    	Thread.sleep(1000);
	    	System.out.println("campaign already deactivate");
	    	Thread.sleep(1000);
	    	System.out.println(camp_id);
	    	//driver.findElement(By.name("campaign_d[31#smriti_in]")).click();
	    	driver.findElement(By.name("campaign_d["+this.camp_id+"#smriti_in]")).click();
	    	
	    }
	    
	    //driver.findElement(By.name("campaign_d[13#smriti_in]")).click();
	    System.out.println("activate deactivate the campaign");
	    Thread.sleep(1000);
	    driver.findElement(By.id("Lists_li_a")).click();  
	    System.out.println("click on list");
	    Thread.sleep(1000);
	    driver.findElement(By.name("list_add_ui")).click();
	    System.out.println("click on add list");
	    Thread.sleep(1000);
	    driver.findElement(By.id("list_name")).clear();
	    driver.findElement(By.id("list_name")).sendKeys("smriti_new_list2");
	    Thread.sleep(1000);
	    System.out.println("enter list name");
	    new Select(driver.findElement(By.id("campaign_id"))).selectByVisibleText("smriti_in");
	    Thread.sleep(1000);
	    System.out.println("select campaign id");
	    driver.findElement(By.id("enable_addcustomer")).click(); 
	    Thread.sleep(1000);
	    System.out.println("enable the customer");
	    //assertEquals("Local Call Start Time:- Field cannot be left blank", closeAlertAndGetItsText());
	    driver.findElement(By.name("local_start_time")).clear();
	    driver.findElement(By.name("local_start_time")).sendKeys("00:00:01");	    
	    Thread.sleep(1000);
	    driver.findElement(By.name("local_end_time")).clear();
	    driver.findElement(By.name("local_end_time")).sendKeys("23:59:59");
	    Thread.sleep(1000);
	    //assertEquals("List Weight: Can Not Be Null", closeAlertAndGetItsText());
	    driver.findElement(By.name("listWeight")).clear();
	    driver.findElement(By.name("listWeight")).sendKeys("1");
	    new Select(driver.findElement(By.id("timezone_tr"))).selectByVisibleText("Asia/Kolkata(IST)");
	    Thread.sleep(1000);
	    driver.findElement(By.name("add_list")).click();
	    System.out.println("list added");
	    System.out.println(driver.switchTo().alert().getText());
	    if(isAlertPresent()){
	    	System.out.println("list already exist");
	        assertEquals("List Name Is Not Available", closeAlertAndGetItsText());
	    }
	    driver.findElement(By.id("Lists_li_a")).click(); 
	    
	    
	    //Upload List
	    System.out.println(TestBase.camp_id);
	    System.out.println(TestBase.list_id1);
	    Thread.sleep(1000);
	    
	    //if(isElementPresent(By.name("campaign_d["+TestBase.camp_id+"#smriti_in]"))){
	  /*if(isElementPresent(By.name("campaign_d[31#smriti_in]"))){
	    driver.findElement(By.name("campaign_d[31#smriti_in]")).click();
	    System.out.println("=====1=====");
	    }*/
	    Thread.sleep(1000);
	   
	    driver.findElement(By.name("list_condition_ui["+TestBase.list_id1+"]")).click();
	    driver.findElement(By.name("File_Name")).clear();
	    driver.findElement(By.name("File_Name")).sendKeys("C:\\Users\\TVT\\Desktop\\DESKTOP\\list_delete.csv");
	    System.out.println("browse the list");
	    driver.findElement(By.name("Upload")).click();
	    System.out.println("upload list");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("field_name"))).selectByVisibleText("name");
	    new Select(driver.findElement(By.id("mob1"))).selectByVisibleText("phonenumber");
	    driver.findElement(By.name("map_list")).click();
	    Thread.sleep(1000);
	    assertEquals("Time Zone1: Are you sure you want to set default timezone by selecting none!", closeAlertAndGetItsText());
	    Thread.sleep(1000);
	  //scroll down
	    JavascriptExecutor js = ((JavascriptExecutor) driver);
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
	    System.out.println("Scroll Down");
	    Thread.sleep(1000);
	    if(isElementPresent((By.name("cmdImport")))){
	    driver.findElement(By.name("cmdImport")).click();
	    Thread.sleep(1000);
	    }
	    System.out.println("list uploaded suceesfully");
	    if(isAlertPresent()){
	    	Thread.sleep(1000);
	    	 System.out.println("Records effected");
	         closeAlertAndGetItsText();
	    }
	    driver.findElement(By.id("Campaigns_li_a")).click();
	    //driver.findElement(By.name("campaign_d["+TestBase.camp_id+"#smriti_in]")).click();
	    
	}
			  
}

