package tests;

import java.io.FileInputStream;
//import java.io.IOException;
import java.util.concurrent.TimeUnit;
import jxl.Sheet;
import jxl.Workbook;
//import jxl.read.biff.BiffException;
//import org.junit.After;
//import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class AgentCreation extends HomePage{
	
		public AgentCreation(WebDriver driver) {
		super(driver);
	}
		  @Test
		  public void agent_creation1() throws Exception {
		    //driver.get(baseUrl);
			  System.out.println("agent creation test case");
		    	    
		    readExcel();	    
		  }
		  public void readExcel() throws Exception {
				String FilePath ="C:\\Users\\TVT\\Desktop\\infomation_of_login.xls";
				FileInputStream fs = new FileInputStream(FilePath);
				Workbook wb = Workbook.getWorkbook(fs);

				// TO get the access to the sheet
				Sheet sh = wb.getSheet("Sheet2");

				// To get the number of rows present in sheet
				int totalNoOfRows = sh.getRows();

				// To get the number of columns present in sheet
				//int totalNoOfCols = sh.getColumns();

				for (int row = 1; row < totalNoOfRows; row++) {
					//System.out.print(sh.getCell(col, row).getContents() + "\t");
					Thread.sleep(10000);
				    System.out.println("click on add agent");
				    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
					wait.pollingEvery(250, TimeUnit.MILLISECONDS);
					wait.withTimeout(2, TimeUnit.MINUTES);
					wait.ignoring(NoSuchElementException.class); // We need to ignore this exception.
				    driver.findElement(By.name("agent_add_ui")).click();
				    driver.findElement(By.id("agent_id")).clear();
				    driver.findElement(By.id("agent_id")).sendKeys(sh.getCell(0, row).getContents());	
				    System.out.println("enter agent_id");
				    driver.findElement(By.name("agent_secret")).clear();
				    driver.findElement(By.name("agent_secret")).sendKeys(sh.getCell(1, row).getContents());	
				    System.out.println("enter agent secret");
				    driver.findElement(By.name("agent_name")).clear();
				    driver.findElement(By.name("agent_name")).sendKeys(sh.getCell(2, row).getContents());	 
				    System.out.println("enter agent_name");
				    new Select(driver.findElement(By.id("campaign_id"))).selectByVisibleText(sh.getCell(3, row).getContents());
				    System.out.println("select campaign");
				    driver.findElement(By.id("sip_pass1")).clear();
				    driver.findElement(By.id("sip_pass1")).sendKeys(sh.getCell(4, row).getContents());  
				    System.out.println("select Sip Password");
				    driver.findElement(By.id("preview_ckh")).click();
				    driver.findElement(By.id("previewSave")).click();
				    driver.findElement(By.name("add_agent")).click();
				    if(isAlertPresent())
					   {
						this.takeSnapShot(driver, "F://agentAlreadyExist.png") ; 
						System.out.println("agent already added");
						closeAlertAndGetItsText();
						driver.findElement(By.name("add_agent")).click();
						 Thread.sleep(10000L);
					   }
				    //closeAlertAndGetItsText();
				    Thread.sleep(10000);
					System.out.println("agent added successfully");
				}
			}

	 
	}

