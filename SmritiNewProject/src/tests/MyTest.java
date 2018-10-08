package tests;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

//************@Author Smriti **************//
public class MyTest extends TestBase {

	// Test-0.
	@Test
	public void testPageObject() throws Exception {
        
		homePage = PageFactory.initElements(driver, HomePage.class);
		driver.get(baseUrl);
        System.out.println(baseUrl);
	    System.out.println("In MyTest");
		//CampaignCreation = homePage.CampaignCreation(); 
		System.out.println(CampaignCreation);
		//CampaignCreation.campaign_creation1();
		System.out.println("campaigncreation");
		
		AgentCreation = homePage.AgentCreation();
		System.out.println("agentcreation");
		AgentCreation.agent_creation1();
		
        ListCreation = homePage.ListCreation();
		ListCreation.List_creation1();
		System.out.println("listCreation");
		
		
		//SipChannel = homePage.sipChannelCreation();
		//SipChannel.sipChann();
		System.out.println("Sipchannel");
		
		
		//VerfierMulti = homePage.VerfierMulti();
	    //VerfierMulti.Verifier();
	    System.out.println("mutiverfier");
	    
	    
	    //ACD_reports = homePage.ACD_reports();
	    System.out.println("go to homepage again");
	    //ACD_reports.acd_reports();
	    System.out.println("report");
	    
	    
	
         }
        }
