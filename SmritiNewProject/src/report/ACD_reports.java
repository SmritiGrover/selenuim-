package report;


import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import LoginDatabaseConnection.LoginDatabaseConn;
import tests.HomePage;

public class ACD_reports extends LoginDatabaseConn{

public ACD_reports(WebDriver driver) {
		super(driver);
		
	}

  @Test 
  public void acd_reports() throws Exception {
	  System.out.println("in  report test case");
	  
	  Thread.sleep(30000);
	  
    //driver.findElement(By.linkText("Reports")).click();
    System.out.println("click on report before");
   
    //driver.findElement(By.xpath("html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[3]/li/a")).click();
    //System.out.println("click on report After");
    driver.findElement(By.id("ACDReports_li_a"));
    System.out.println(driver.findElement(By.id("ACDReports_li_a")));
	System.out.println(driver.findElement(By.id("ACDReports_li_a")));
	 driver.findElement(By.id("ACDReports_li_a")).click();
	System.out.println("click on ACD reports");
    //new Select(driver.findElement(By.id("campaign"))).selectByVisibleText("hridesh");
   // System.out.println("select campaign");
    //driver.findElement(By.name("currentDate")).click();
    //System.out.println("current date");
    Thread.sleep(1000);
    driver.findElement(By.name("summary")).click();
    System.out.println("summary");
    Thread.sleep(1000);
    driver.findElement(By.id("ACDReports_li_a")).click();
    Thread.sleep(1000);
    //driver.findElement(By.id("ACDReports_li_a")).click();
    driver.findElement(By.name("detailed")).click();
    System.out.println("detailed call report");
    Thread.sleep(1000);
    driver.findElement(By.id("exportFromReport")).click();
    System.out.println("export report");
    Thread.sleep(1000);
    driver.findElement(By.id("ACDReports_li_a")).click();
    //driver.findElement(By.name("detailed")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("ACDReports_li_a")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("timeinterval")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("ACDReports_li_a")).click();
    Thread.sleep(10000);
    driver.findElement(By.name("daily")).click();
    System.out.println("dialy call summary");
    Thread.sleep(10000);
    driver.findElement(By.id("ACDReports_li_a")).click();
    Thread.sleep(10000);
    driver.findElement(By.name("time_summary")).click();
    System.out.println("time summary");
    Thread.sleep(10000);
    driver.findElement(By.id("ACDReports_li_a")).click();
    Thread.sleep(10000);
    driver.findElement(By.name("line_summary")).click();
    System.out.println("line summmary");
    Thread.sleep(10000);
    driver.findElement(By.id("ACDReports_li_a")).click();
    Thread.sleep(10000);
    driver.findElement(By.name("abandon")).click();
    System.out.println("abandon report");
    Thread.sleep(10000);
    driver.findElement(By.id("ACDReports_li_a")).click();
    Thread.sleep(10000);
    driver.findElement(By.name("amd")).click();
    System.out.println("amd report");
    Thread.sleep(10000);
    driver.findElement(By.id("ACDReports_li_a")).click();
    Thread.sleep(10000);
    driver.findElement(By.name("failure")).click();
    System.out.println("failure report");
    Thread.sleep(1000);
    driver.findElement(By.id("ACDReports_li_a")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("breakreport")).click();
    System.out.println("break report");
    Thread.sleep(1000);
    driver.findElement(By.id("ACDReports_li_a")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("agent_session_report")).click();
    System.out.println("agent seesion report");
    Thread.sleep(1000);
    driver.findElement(By.id("ACDReports_li_a")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("agent_summary_report")).click();
    System.out.println("agent summary report");
    Thread.sleep(1000);
    driver.findElement(By.id("ACDReports_li_a")).click();
    Thread.sleep(1000);
    new Select(driver.findElement(By.id("campaign"))).selectByVisibleText("hridesh");
    Thread.sleep(1000);
    driver.findElement(By.name("detailed")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("fields_mapping_div_button")).click();
    System.out.println("field mapping");
    
    Thread.sleep(1000);
    driver.findElement(By.name("Close")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("exportFromReport")).click();
    System.out.println("export from report");
    Thread.sleep(1000);
    driver.findElement(By.name("moveAllLeft")).click();
    System.out.println("move all left");
    Thread.sleep(1000);
    driver.findElement(By.id("detailReport")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("exportFromReport")).click();
    System.out.println("export from report");
    Thread.sleep(1000);
    driver.findElement(By.name("moveAllRight")).click();
    System.out.println("move all right");
    Thread.sleep(1000);
    driver.findElement(By.id("detailReport")).click();
    Thread.sleep(1000);
    System.out.println("report end here");
  }

	/*@After
	public void closeConn() throws SQLException {
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}*/
	
}


