package automationTests;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationFramework.NavigationBar.NavigateBar;
import automationFramework.Reports.ReportMenu;
import automationFramework.WebPages.LoginPage;
import automationFramework.WebPages.WelcomePage;
import util.CsvDataProviders;
import util.TestUtilities;

public class PositiveLogInTests extends ReportMenu {
	Logger log = LoggerFactory.getLogger("PositiveLogInTests");
	
	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void positiveLogInTest(Map<String, String> testData) {
		// Data
		String no = testData.get("no");
		String username  = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");
		
		log.info("Starting negativeLogInTest #" + no + " for " + description);

		// open main page;
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1)
	public void openReportsPage() throws Exception {
		
		NavigateBar.click().utilitiesMenu().click().reports().click();
		//UtilitiesMenu.click().reports().click();

		//New page url is expected
		Assert.assertEquals(reportsPage.getCurrentUrl(), reportsPage.getPageUrl());

		// Successful log in message
		String expectedSuccessMessage = "Client Reports";
		String actualSuccessMessage = reportsPage.getPageTitleText();
		
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
		
	}
	
	@Test(priority=1)
	public void verify_SecureAreaPageTest() throws Exception {
		
		// Expected page url
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

		// Expected page title
		String expectedSuccessMessage = "Deal Status Queue";
		String actualSuccessMessage = secureAreaPage.getPageTitleText();
		
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=3)
	public void verify_BatchManagerPage_Test() throws Exception {
		
		//Workflow
		NavigateBar.comboBox().search("MN Test").batchManager().click();
		//NavigateBar.comboBox().search("MN Test");
		//ComboBoxPage.search("MN Test");
		//NavigateBar.batchManager().click();
		
		
		//Expected page url
		Assert.assertEquals(batchManagerPage.getCurrentUrl(), batchManagerPage.getPageUrl());

		// Expected page title
		String expectedSuccessMessage = "Batch Manager";
		String actualSuccessMessage = batchManagerPage.getSuccessMessageText();
		
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

	}
	
	@SuppressWarnings("static-access")
	@Test(priority=4)
	public void verify_TransactionsPage_Test() throws Exception {
		
		//Workflow
		NavigateBar.transactions().click();
		NavigateBar.comboBox().search("MN Test");

		//Expected page url
		Assert.assertEquals(transactionsPage.getCurrentUrl(), transactionsPage.getPageUrl());

		// Expected page title
		String expectedSuccessMessage = "Setup";
		String actualSuccessMessage = transactionsPage.getPageTitleText();
		
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

	}
}
