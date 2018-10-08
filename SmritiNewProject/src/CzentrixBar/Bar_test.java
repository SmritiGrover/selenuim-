package CzentrixBar;

//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Bar_test {

	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @Before
	  public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "F:/gecko/geckodriver.exe");
	    driver = new FirefoxDriver();
	   baseUrl = "http://192.168.1.100/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @Test
	  public void Bar_call() throws Exception {
	    driver.get(baseUrl + "czhandler/cti_handler.php?e=31111");
	    Thread.sleep(2000);
	    System.out.println("Bar call start");
	    driver.switchTo().frame(driver.findElement(By.name("main_call_window")));
	    Thread.sleep(1000);
	   System.out.println("switch to iframe");
	    driver.findElement(By.id("n")).clear();
	    driver.findElement(By.id("n")).sendKeys("878877777");
	    Thread.sleep(1000);
	    driver.findElement(By.id("dial_phone")).click();
	    Thread.sleep(10000);
	    //driver.navigate().refresh();
	    //System.out.println("refresing the window");
	    //Thread.sleep(2000);
	   
		System.out.println("dial");
		
	    if (isElementPresent(By.id("hold")))
	    {   System.out.println("in if");
	    	driver.findElement(By.id("hold")).click();
            System.out.println("hold");  
	        Thread.sleep(2000);
	        driver.findElement(By.id("unhold")).click();	
	        System.out.println("unhold");
	    }
	    
	    Thread.sleep(2000);
	    driver.findElement(By.id("take_break")).click();	    
	    new Select(driver.findElement(By.id("break_reason_dd"))).selectByVisibleText("BREAK");	 
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("option[value=\"BREAK\"]")).click();	  
	    driver.findElement(By.id("final_take_break")).click(); 
	    System.out.println("out of break");
	    Thread.sleep(1000);
	    driver.findElement(By.id("call_conference")).click(); 
	    System.out.println("click on conf");
	    Thread.sleep(1000);
	    driver.findElement(By.name("backToMain[31111]")).click(); 
	    System.out.println("back to main");
	    Thread.sleep(1000);
	    driver.findElement(By.id("get_disposition")).click();	
	    Thread.sleep(1000);
	    driver.findElement(By.id("category_dd")).click();	
	    Thread.sleep(1000);
	    driver.findElement(By.id("disposition_dd")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("comments")).click();   
	    driver.findElement(By.id("comments")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.id("comments")).sendKeys("test");	   
	    driver.findElement(By.id("set_disposition")).click();	
	    Thread.sleep(1000);
	    driver.findElement(By.id("disconnect")).click();	
	    Thread.sleep(1000);
	    //driver.findElement(By.id("back_from_break")).click();    
	  }

	  @After
	  public void tearDown() throws Exception {
	   // driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
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

	  public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
