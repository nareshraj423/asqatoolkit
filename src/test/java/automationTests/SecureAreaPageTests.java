package automationTests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationFramework.NavigationBar.*;
import automationFramework.ReportPages.ReportMenu;

public class SecureAreaPageTests extends ReportMenu {
	
	Logger log = LoggerFactory.getLogger("SecureAreaPageTests.class");

	@Test(priority=1)
	public void verify_PageURL_PageTitle_Test() throws Exception {
		
		// Expected page url
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

		// Expected page title
		String expectedSuccessMessage = "Deal Status Queue";
		String actualSuccessMessage = secureAreaPage.getPageTitleText();
		
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}
	
	@Test(priority=2)
	public void verify_DealerStatusQueuePage_Test() throws Exception {
		
		//Workflow
		NavigateBar.comboBox().search("MN Test Client").dealStatusQueue().click();

		//Expected page url
		Assert.assertEquals(dealStatusQueuePage.getCurrentUrl(), dealStatusQueuePage.getPageUrl());

		// Expected page title
		String expectedSuccessMessage = "Deal Status Queue";
		String actualSuccessMessage = dealStatusQueuePage.getPageTitleText();
		
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

	}
	
	@Test(priority=3)
	public void verify_BatchManagerPage_Test() throws Exception {
		
		//Workflow
		NavigateBar.batchManager().click();

		//Expected page url
		Assert.assertEquals(batchManagerPage.getCurrentUrl(), batchManagerPage.getPageUrl());

		// Expected page title
		String expectedSuccessMessage = "Batch Manager";
		String actualSuccessMessage = batchManagerPage.getPageTitleText();
		
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

	}
	
	@Test(priority=4)
	public void verify_TransactionsPage_Test() throws Exception {
		
		//Workflow
		NavigateBar.transactions().click();
		//NavigateBar.comboBox().search("MN Test Client - USA1234");

		//Expected page url
		Assert.assertEquals(transactionsPage.getCurrentUrl(), transactionsPage.getPageUrl());

		// Expected page title
		String expectedSuccessMessage = "Setup";
		String actualSuccessMessage = transactionsPage.getPageTitleText();
		
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

	}
	
	@Test(priority=5)
	public void verify_ManageMenu_Users_Test() throws Exception {
		
		//NavigateBar.manage().usersPage();
		
		//New page url is expected
		//Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

		// Successful log in message
		//String expectedSuccessMessage = "";
		//String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
		
		//Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				//"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						//+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

	}
	
	@Test(priority=6)
	public void verify_UtilitiesMenu_ReportsPage_Test() throws Exception {
		
		NavigateBar.utilitiesMenu().click();
		UtilitiesMenu.reports().click();

		//New page url is expected
		Assert.assertEquals(reportsPage.getCurrentUrl(), reportsPage.getPageUrl());

		// Successful log in message
		String expectedSuccessMessage = "Client Reports";
		String actualSuccessMessage = reportsPage.getPageTitleText();
		
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
		
	}
	
	@Test(priority=7)
	public void verify_StandardTransactionExportReport_Test() throws Exception {
		
		NavigateBar.utilitiesMenu().click();
		UtilitiesMenu.reports().click();
		
		reportsPage.reportMenu().click();
		ReportMenu.standardTransactionExport().click();

		//New page url is expected
		Assert.assertEquals(standardTransactionExport.getCurrentUrl(), standardTransactionExport.getPageUrl());

		// Successful log in message
		String expectedSuccessMessage = "Client Reports";
		String actualSuccessMessage = standardTransactionExport.getPageTitleText();
		
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
		
		
	}
}
