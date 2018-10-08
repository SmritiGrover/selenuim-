

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import tests.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BarConfiguaration {
  private WebDriver driver;
  private String baseUrl;
  private String xyz;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "F:/gecko/geckodriver.exe");
	    driver = new FirefoxDriver();
	    baseUrl = "http://192.168.1.57/";
	    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
  }

  @Test
  public void BarConfiguaration1() throws Exception {
    driver.get(baseUrl + "/adminui.php");
    driver.findElement(By.name("pwd")).clear();
    driver.findElement(By.name("pwd")).sendKeys("rwpass");
    driver.findElement(By.name("uid")).clear();
    driver.findElement(By.name("uid")).sendKeys("adminrw");
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.name("login_existing_agent")).click();
    //driver.findElement(By.cssSelector("div > img")).click();
    Thread.sleep(3000);
    
    driver.findElement(By.linkText("Call Center")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("Campaigns_li_a")).click();
    Thread.sleep(2000);
    //tests.TestBase.camp_id;
    this.xyz=tests.TestBase.camp_id;
   // this.xyz=tests.TestBase.camp_id;
    driver.findElement(By.name("bar_conf_btn[31]")).click();
    //driver.findElement(By.id("dial_visible")).click();
    driver.findElement(By.id("dial_visible")).click();
    //driver.findElement(By.id("readonly_dial")).click();
    //driver.findElement(By.id("readonly_dial")).click();
    driver.findElement(By.id("readonly_dial")).click();
    //driver.findElement(By.id("disconnect_visible")).click();
    driver.findElement(By.id("disconnect_visible")).click();
    //driver.findElement(By.id("ready")).click();
    driver.findElement(By.id("ready")).click();
    driver.findElement(By.id("hold")).click();
    //driver.findElement(By.id("break")).click();
    driver.findElement(By.id("break")).click();
    //driver.findElement(By.id("pre_break_check")).click();
    driver.findElement(By.id("pre_break_check")).click();
    //driver.findElement(By.id("transfer")).click();
    driver.findElement(By.id("transfer")).click();
    driver.findElement(By.id("transfer_agent")).click();
    driver.findElement(By.id("transfer_campaign")).click();
    driver.findElement(By.id("transfer_to_extension")).click();
    //driver.findElement(By.id("conf_visible")).click();
    driver.findElement(By.id("conf_visible")).click();
    
    //driver.findElement(By.id("disposition")).click();
    driver.findElement(By.id("disposition")).click();
    driver.findElement(By.id("next_call_time")).click();
    driver.findElement(By.id("ivrs_path")).click();
    //driver.findElement(By.id("switch_mode")).click();
    driver.findElement(By.id("switch_mode")).click();
    //driver.findElement(By.id("campaign")).click();
    driver.findElement(By.id("campaign")).click();
    //driver.findElement(By.id("comments")).click();
    driver.findElement(By.id("comments")).click();
    driver.findElement(By.id("call_in_queue")).click();
    driver.findElement(By.id("dialer_disposition")).click();
    driver.findElement(By.id("logout_visible_check")).click();
    driver.findElement(By.id("features_submit")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
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
