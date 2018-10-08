package AgentCalling;

//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class conf_test {
  private WebDriver driver;
  private String baseUrl;
 // private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "F:/gecko/geckodriver.exe");	
    driver = new FirefoxDriver();
    baseUrl = "http://172.16.2.220/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testConf() throws Exception {
    driver.get(baseUrl + "/supervisedTransfer.php?agentid=3131");
   
    //driver.findElement(By.cssSelector("a[title=\"Conferencing\"] > img")).click();
   
    driver.findElement(By.id("transfer_supervisor1")).click();
    Thread.sleep(20000);
    driver.findElement(By.id("txt_cust_ph")).clear();
    Thread.sleep(20000);
    driver.findElement(By.id("txt_cust_ph")).sendKeys("1111111");
    Thread.sleep(20000);
    driver.findElement(By.id("dial_VDN")).click();
    Thread.sleep(20000);
    driver.findElement(By.id("TB1")).click();
    Thread.sleep(20000);
    driver.findElement(By.name("backtoqueue[3131]")).click();
  }

  @After
  public void tearDown() throws Exception {
    //driver.quit();
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


 
}
