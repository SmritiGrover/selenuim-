package tests;
//import org.openqa.selenium.By;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import report.ACD_reports;
import verifierMultiverfier.VerfierMulti;
//********@Author Smriti **************//
public class HomePage extends TestBase{
	public static WebDriver driver;
	public boolean acceptNextAlert = true;
	@FindBy(id = "Campaigns_li_a")
	WebElement campaign;

	@FindBy(id = "Agents_li_a")
	WebElement agent;

	@FindBy(id = "Lists_li_a")
	WebElement list;
	
	@FindBy(id = "SIPChannelConfiguration_li_a")
	WebElement sipChannel;
	
	
	@FindBy(id = "MultiVerifier_li_a")
	WebElement multiverifier;
	
	@FindBy(id = "Reports_li_a")
	WebElement Reports;
	
      public HomePage(WebDriver driver) {	
		System.out.println("in");
		this.driver = driver;
		
	}

	// Method-1.
	public CampaignCreation CampaignCreation() throws InterruptedException {
		System.out.println("in home Page");
		System.out.println("come in campaign creation");
		campaign.click();
		System.out.println("i am smriti");
	    Thread.sleep(10000);
		driver.findElement(By.id("Campaigns_li_a")).click();
		System.out.println("campaign click by simi");
		Thread.sleep(1000);
		return PageFactory.initElements(driver, CampaignCreation.class);
		 
	}

	// Method-2.
	public AgentCreation AgentCreation() {
		System.out.println("in home Page");
		System.out.println("come in the agent creation");
		//driver.findElement(By.id("Agents_li_a")).click();
		agent.click();
		return PageFactory.initElements(driver, AgentCreation.class);
	}

	// Method-3.
	public ListCreation ListCreation() {
		System.out.println("in home Page");
		System.out.println("come in list creation");
		//driver.findElement(By.id("Lists_li_a")).click();
		list.click();
		return PageFactory.initElements(driver, ListCreation.class);
	}
	
	
	 
	// Method-4.
		public sipChannelCreation sipChannelCreation() {
			System.out.println("in home Page");
			System.out.println("come in sip channels");			
			sipChannel.click();
			return PageFactory.initElements(driver, sipChannelCreation.class);
		}
	
	// Method-5.
		public verifierMultiverfier.VerfierMulti  VerfierMulti() {
			System.out.println("in home Page");
			System.out.println("come in verifier");					
			multiverifier.click();
			return PageFactory.initElements(driver, VerfierMulti.class);
		}
				
				
	// Method-6.
	public report.ACD_reports ACD_reports() {
			System.out.println("in home Page");
			System.out.println("come in ACD");	
			this.Reports.click();
			System.out.println("=====");
			return PageFactory.initElements(driver, ACD_reports.class);
			
		}	
	    
		
	//Method 5.1.
	public String closeAlertAndGetItsText() throws InterruptedException {
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
	
	//Method 6
	public boolean isAlertPresent() {
		try {
			if(driver.switchTo().alert()!=null){
			  System.out.println("alert present");
			return true;
			}
			else return false;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	//Method 7
	//funtion for taking screeenshort
		public void takeSnapShot(WebDriver dr,String fileWithPath) throws Exception{

	      //Convert web driver object to TakeScreenshot
	         TakesScreenshot scrShot =((TakesScreenshot)dr);
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
		
		
		//Method 8
		
		public static boolean isNumeric(String txt) {
			String regx = "[0123456789]";
		    Pattern pattern = Pattern.compile(regx);
		    Matcher matcher = pattern.matcher(txt);
		    return matcher.find();
		}
		
		//Method 9
		
		public boolean isElementPresent(By by) {
			try {
				driver.findElement(by);
				return true;
			} catch (NoSuchElementException e) {
				return false;
			}
		}
		
		public static void multipleselect_box(String name, String field) throws InterruptedException{
			Select oSelection = new Select(driver.findElement(By.name(name)));
		    
		    List oSize = oSelection.getOptions();
	        int iListSize = oSize.size();
	        for(int i =0; i < iListSize ; i++){
	            String sValue = oSelection.getOptions().get(i).getText();
	            if(sValue.equalsIgnoreCase(field)){
	            	oSelection.selectByIndex(i);
	            	break;
	            }
	            Thread.sleep(1000);
	        }
		}

		


}
