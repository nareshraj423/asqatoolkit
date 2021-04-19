package automationFramework.ReportPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.Driver.Driver;
import automationFramework.NavigationBar.ReportsPage;
import automationFramework.NavigationBar.UtilitiesMenu;

public class ReportMenu extends UtilitiesMenu {

	Logger log = LoggerFactory.getLogger("ReportMenu.class");

	private By reportButtonLocator = By.xpath("//button[@id='button-menu']");
	
	public static StandardTransactionExportPage standardTransactionExport;

	public ReportMenu click() throws InterruptedException {
		//log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
		click(reportButtonLocator);
		Thread.sleep(1000);
		takeScreenshot("ReportMenu opened");
		return new ReportMenu();
	}

	public static StandardTransactionExportPage standardTransactionExport() {
		standardTransactionExport = PageFactory.initElements(Driver.instance, StandardTransactionExportPage.class);
		return new StandardTransactionExportPage();
	}

}
