package CzentrixBar;
//import java.util.regex.Pattern;
//import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.*;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class vertical_bar {

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
	  public void vertical_bar1() throws Exception {
	    driver.get(baseUrl + "bar/cti_handler.php?e=31111");
	    Thread.sleep(1000);
	    driver.switchTo().frame(driver.findElement(By.name("main_call_window")));
	    System.out.println("enter in main window");
	    //driver.findElement(By.id("ready")).click();
	    System.out.println("click on ready");
	    //Thread.sleep(10000);
	    //driver.findElement(By.id("switch_to_preview")).click();
	    System.out.println("click on switch to preview");
	    Thread.sleep(10000);
	   /* driver.findElement(By.id("take_break")).click();
	    System.out.println("take break");
	    Thread.sleep(10000);
	    new Select(driver.findElement(By.id("break_reason_dd"))).selectByVisibleText("BREAK");
	    Thread.sleep(10000);
	    driver.findElement(By.id("final_take_break")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.id("back_from_break")).click();*/
	    System.out.println("back from break");
	    Thread.sleep(10000);
	    driver.findElement(By.id("switch_to_progressive")).click();
	    System.out.println("switch to pregressive");
	    Thread.sleep(10000);
	    driver.findElement(By.id("switch_to_preview")).click();
	    System.out.println("switch to preview");
	    Thread.sleep(10000);
	    driver.findElement(By.id("n")).clear();
	    driver.findElement(By.id("n")).sendKeys("231333");
	    System.out.println("insert the number");
	    driver.findElement(By.id("dial_phone")).click();
	    System.out.println("dial number");
	    Thread.sleep(10000);
	    driver.findElement(By.id("call_conference")).click();
	    Thread.sleep(10000);
	    System.out.println("confernce");
	    driver.findElement(By.id("transfer")).click();
	    System.out.println("transfer");
	    Thread.sleep(10000);
	    driver.findElement(By.id("conf_phone2")).clear();
	    driver.findElement(By.id("conf_phone2")).sendKeys("111111");
	    System.out.println("conf 2");
	    new Select(driver.findElement(By.id("dial_type"))).selectByVisibleText("External");
	    driver.findElement(By.id("conf_dial")).click();
	    driver.findElement(By.name("join_agent_cust_conf[]")).click();
	    Thread.sleep(30000);
	    System.out.println("join conference");
	    //driver.findElement(By.xpath("//input[@value='Back To Queue' and @type='submit']")).click();
	    driver.findElement(By.xpath(".//*[@id='main_conference']/tbody/tr[5]/td/input")).click();
	   // driver.findElement(By.name("backtoqueue")).click();
	    System.out.println("back to queue");
	    Thread.sleep(20000);
	    driver.findElement(By.xpath(".//*[@id='main_conference']/tbody/tr[4]/td/input")).click();
	    //driver.findElement(By.name("backToMain[3131]")).click();
	    System.out.println("back to main");
	  }

	  
	  
	  @After
	  
	  public void tearDown() throws Exception {
	    //driver.quit();
	   String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	     // fail(verificationErrorString);
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
