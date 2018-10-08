package tests;
import java.io.FileInputStream;

//import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;


//import org.junit.Assume;
//import org.junit.Before;
//import jxl.read.biff.BiffException;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


 public class CampaignCreation extends HomePage {
	
	public CampaignCreation(WebDriver driver) {
		super(driver);
		
	}
	
	  @Test
	  public void campaign_creation1() throws Exception {
		  
		  
		  try{
			  
		         System.out.println("Come in campaign creation test case");
		         
                 driver.findElement(By.id("Campaigns_li_a")).click();
                 System.out.println("click");
                 Thread.sleep(10000);
                 
                 readExcel();
                 
		  }catch (NoSuchElementException e) {
			  System.err.format("No Element Found to click" + e);
		  }
		  
		    driver.findElement(By.id("Campaigns_li_a")).click();
		    Thread.sleep(10000);
		    System.out.println(camp_id +"campaign name "+ camp_name);
		    
		    driver.findElement(By.name("agent_disposition["+this.camp_id+"]")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("add_disp")).click();
		    driver.findElement(By.id("cust_disp_0")).clear();
		    driver.findElement(By.id("cust_disp_0")).sendKeys("basic_disp");
		    driver.findElement(By.id("disp_more")).click();
		    driver.findElement(By.id("cust_disp_1")).clear();
		    driver.findElement(By.id("cust_disp_1")).sendKeys("verifier_disp");
		    driver.findElement(By.id("disp_more")).click();
		    driver.findElement(By.id("cust_disp_2")).clear();
		    driver.findElement(By.id("cust_disp_2")).sendKeys("verifier");
		    driver.findElement(By.id("checkbox2_2")).click();
		    driver.findElement(By.id("disp_more")).click();
		    driver.findElement(By.id("cust_disp_3")).clear();
		    driver.findElement(By.id("cust_disp_3")).sendKeys("multiverfier");
		    driver.findElement(By.id("checkbox2_3")).click();
		    driver.findElement(By.id("disp_more")).click();
		    driver.findElement(By.id("delete_btn4")).click();
		    driver.findElement(By.id("agent_cust_save")).click();
		    driver.findElement(By.id("Campaigns_li_a")).click();
     } 
	  
      public void readExcel() throws Exception {
    	  
	 try{
		 
	                System.out.println("come in funtion");
		            String FilePath ="C:\\Users\\TVT\\Desktop\\infomation_of_login.xls";
		            System.out.println(FilePath);
		            FileInputStream fs = new FileInputStream(FilePath);
		            Workbook wb = Workbook.getWorkbook(fs);
                    System.out.println("1");
		            // TO get the access to the sheet
		            Sheet sh = wb.getSheet("Sheet3");
		            System.out.println("2");
		             // To get the number of rows present in sheet
		             int totalNoOfRows = sh.getRows();
		             System.out.println("3");
		             // To get the number of columns present in sheet
		             for (int row = 1; row < totalNoOfRows; row++) {
		            	 
			           System.out.println("come in for loop" +totalNoOfRows);
			
			           Thread.sleep(10000);
			          driver.findElement(By.xpath("//input[@value='Add Campaign' and @type='submit']")).click();
		              System.out.println("click on add campaign");
		         
		              driver.findElement(By.id("campaign_name")).clear();
					  driver.findElement(By.id("campaign_name")).sendKeys(sh.getCell(0, row).getContents());	 
					  System.out.println("campaign name");
		   
					    new Select(driver.findElement(By.id("inOutSelect"))).selectByVisibleText(sh.getCell(1, row).getContents());
					    System.out.println("inout select");
					    new Select(driver.findElement(By.id("autodial_level"))).selectByVisibleText(sh.getCell(2, row).getContents());
					    System.out.println("autodial level");  
					    driver.findElement(By.name("local_start_time")).clear();
					    driver.findElement(By.name("local_start_time")).sendKeys(sh.getCell(3, row).getContents());
					    System.out.println("start time");
					    driver.findElement(By.id("local_end_timeId")).clear();
					    driver.findElement(By.id("local_end_timeId")).sendKeys(sh.getCell(4, row).getContents()); 
					    System.out.println("end time");
					    new Select(driver.findElement(By.name("agentui_timezone"))).selectByVisibleText(sh.getCell(5, row).getContents());
					    System.out.println("timezone");
					    
				        //scroll down
		               JavascriptExecutor js = ((JavascriptExecutor) driver);
		               js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
		               System.out.println("Scroll Down");
		               Thread.sleep(2000);    
		               driver.findElement(By.xpath(".//*[@id='skill_based_routing_tr']/td[2]/input")).click();
		               System.out.println("skill based routing");
		              
				       driver.findElement(By.name("add_campaign")).click();				  
					   System.out.println("campaign added");
					   //System.out.println(driver.switchTo().alert().getText());
					   Thread.sleep(1000);
					   
					   if(isAlertPresent())
					   {
						//this.takeSnapShot(driver, "F://test.png") ; 
						System.out.println("campaign already added");
						closeAlertAndGetItsText();
						 driver.findElement(By.id("Campaigns_li_a")).click();
						 Thread.sleep(10000L);
					   }
					
					// Thread.sleep(10000);
								 
			 
				}
			 }catch (NoSuchElementException e) {
					  System.err.format("No Element Found" + e);
		
			 }
	}
 


} 
