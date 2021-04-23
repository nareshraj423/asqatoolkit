package automationTests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import automationFramework.NavigationBar.*;
import automationFramework.Reports.ReportMenu;

public class ReportsPageTests extends ReportMenu {
	
	Logger log = LoggerFactory.getLogger("ReportsPageTests.class");
	
	@SuppressWarnings("static-access")
	@Test(priority=1)
	public void openReportsFromUtilitiesMenuPage() throws Exception {
		
		// Workflow
		NavigateBar.click().utilitiesMenu().click().reports().click();
		// Alternate workflow
		//UtilitiesMenu.click().reports().click();
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=2)
	public void clickStandardTransactionExportReport() throws Exception {
		
		NavigateBar.utilitiesMenu().click()
				   .reports().click()
				   .reportMenu().click()
				   .standardTransactionExport().click();
		
	}

	@SuppressWarnings("static-access")
	@Test(priority=3)
	public void filterStandardTransactionExportReport() throws Exception {
		
		//NavigateBar.comboBox().search("MN Test");
		NavigateBar.comboBox().search("MN Test")
					.utilitiesMenu().click()
					.reports().click()
					.reportMenu().click()
					.standardTransactionExport().click();
		
		reportsPage.filterButton().date("03/03/2021","04/23/2021")
								  .state("")
								  .client("All")
								  .build()
								  .apply();
		
		reportsPage.download().pdf();

	}

}
