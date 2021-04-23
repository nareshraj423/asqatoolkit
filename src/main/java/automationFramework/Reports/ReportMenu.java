package automationFramework.Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.Driver.Driver;
import automationFramework.NavigationBar.UtilitiesMenu;
import automationFramework.NavigationBar.Utilities.ReportsPage;

public class ReportMenu extends ReportsPage {

	Logger log = LoggerFactory.getLogger("ReportMenu.class");

	//private static By reportsButtonLocator = By.xpath("//a[@id='nav-reports']");
	
	public static StandardTransactionExportPage standardTransactionExport;

	private static By reportMenuLocator = By.xpath("//button[@id='button-menu']");

	
	public ReportMenu() {
		return;
	}
	
	public static ReportMenu click() {
		WebElement webelement = find(reportMenuLocator);
		hoverOverElement(webelement);
		click(reportMenuLocator);
		sleep(1000);
		takeScreenshot("ReportMenu opened");
		return new ReportMenu();
	}

	public static StandardTransactionExportPage standardTransactionExport() {
		standardTransactionExport = PageFactory.initElements(Driver.instance, StandardTransactionExportPage.class);
		return new StandardTransactionExportPage();
	}

}
