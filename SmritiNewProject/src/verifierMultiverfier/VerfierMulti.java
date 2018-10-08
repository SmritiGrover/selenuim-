package verifierMultiverfier;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import tests.HomePage;


public class VerfierMulti extends HomePage{
	  public VerfierMulti(WebDriver driver) {
		super(driver);
		
	}
	  

	@Test
	  public void Verifier() throws Exception {
		System.out.println("in verifier test case");
	    driver.findElement(By.linkText("Multi Verifier")).click();
	    System.out.println("click on multiverfier");
	    driver.findElement(By.cssSelector("td.highlight > input[type=\"image\"]")).click();
	    System.out.println("click on image");
	    new Select(driver.findElement(By.id("cboCampaign"))).selectByVisibleText("smriti");
	    System.out.println("select basic campaign");
	    new Select(driver.findElement(By.name("supCampaign"))).selectByVisibleText("smriti_in");
	    System.out.println("select verifier campaign");
	    driver.findElement(By.name("cmdSubmit")).click();
	    System.out.println("click on submit");
	    Thread.sleep(10000);
	    driver.findElement(By.id("Step2_li_a")).click();
	    System.out.println("click on step 2");
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("td.highlight > input[type=\"image\"]")).click();
	    System.out.println("click on image");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.xpath("(//select[@id='campaignName'])[2]"))).selectByVisibleText("smriti");
	    System.out.println("select campaign");
	    
	    Thread.sleep(1000);
	        Select selectBox = new Select(driver.findElement(By.id("campAgent")));       
	        selectBox.selectByValue("3131");  
	        System.out.println("select agent");

	   
		//Select oSelect = new Select(driver.findElement(By.id("campAgent")));
		//oSelect.selectByValue("smriti");
       
	    Select oSelect1 = new Select(driver.findElement(By.id("campDisp")));
		oSelect1.selectByValue("adasda");
	    System.out.println("select disp");
	    Thread.sleep(10000);
	    new Select(driver.findElement(By.name("supAgent"))).selectByVisibleText("simmi");
	    System.out.println("select verfier agent");
	    Thread.sleep(10000);
	    //assertEquals("Please select verifier Agent!", closeAlertAndGetItsText());
		driver.findElement(By.name("cmdSubmit")).click();
        System.out.println("submit");
        Thread.sleep(10000);
		driver.findElement(By.id("Step3_li_a")).click();
		System.out.println("click on step3");
		Thread.sleep(1000);
		
		//driver.findElement(By.cssSelector("td.highlight > input[type=\"image\"]")).click();
	    driver.findElement(By.name("host_name")).click();
	    System.out.println("select host name");
	    new Select(driver.findElement(By.id("campaignName1"))).selectByVisibleText("smriti");
	    System.out.println("select campaign");
	    new Select(driver.findElement(By.id("verifier_Campaign"))).selectByVisibleText("smriti_in");
        System.out.println("selct verfier camp");
        Thread.sleep(1000);
	    Select oSelect2 = new Select(driver.findElement(By.id("V_custDisp")));
		oSelect2.selectByValue("wwww");
	    System.out.println("select verfier disp");
	    Thread.sleep(1000);
	    driver.findElement(By.name("moveSelectedRight")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.name("V_saveDisp1")).click();
	    Thread.sleep(1000);
	    //new Select(driver.findElement(By.xpath("(//select[@id='campaignName'])[2]"))).selectByVisibleText("smriti");
	    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		wait.withTimeout(1, TimeUnit.MINUTES);
		wait.ignoring(NoSuchElementException.class); // We need to ignore this exception.
	  }


}
