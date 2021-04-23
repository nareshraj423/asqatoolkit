package automationTests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import automationFramework.NavigationBar.*;
import automationFramework.Reports.ReportMenu;

public class Smoke_Sanity_Tests extends ReportMenu {
	
	Logger log = LoggerFactory.getLogger("Smoke_Sanity_Tests.class");

	@Test(priority=1)
	public void verify_SecureAreaPageTest() throws Exception {
		
		// Check if the code has entered login credentials.
		// Verify user is able to login and logout smoothly.
				
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=2)
	public void verify_DealerStatusQueuePage_Test() throws Exception {
		
		//Workflow
		NavigateBar.comboBox().search("MN Test");
		NavigateBar.dealStatusQueue().click();
		
	}

	@SuppressWarnings("static-access")
	@Test(priority=3)
	public void verify_BatchManagerPage_Test() throws Exception {
		
		//Workflow
		NavigateBar.comboBox().search("MN Test").batchManager().click();
		
		//NavigateBar.comboBox().search("MN Test");
		//ComboBoxPage.search("MN Test");
		//NavigateBar.batchManager().click();
		
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=4)
	public void verify_TransactionsPage_Test() throws Exception {
		
		//Workflow
		NavigateBar.transactions().click();
		NavigateBar.comboBox().search("MN Test");

	}

}
