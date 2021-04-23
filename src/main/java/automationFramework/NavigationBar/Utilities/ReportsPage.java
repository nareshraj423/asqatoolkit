package automationFramework.NavigationBar.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.Driver.Driver;
import automationFramework.NavigationBar.UtilitiesMenu;
import automationFramework.Reports.DownloadMenu;
import automationFramework.Reports.ReportFilter;
import automationFramework.Reports.ReportFilter.ReportFilterBuilder;
import automationFramework.Reports.ReportMenu;

public class ReportsPage extends UtilitiesMenu {

	Logger log = LoggerFactory.getLogger("ReportsPage.class");

	private static By reportsButtonLocator = By.xpath("//a[@id='nav-reports']");
	
	//Internal View
	//private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/dsq;dealerId=2425";
	
	//External View
	private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/jrs-reports";

	private By table = By.xpath("//a[@id='logoutlink']");
	private By message = By.xpath("//h3[contains(text(),'Client Reports')]");
	private static By filterbuttonlocator = By.xpath("//ul[@class=\"list-inline pipes\"]/child::li[2]/child::button");

	private static ReportMenu reportMenu;
	private static DownloadMenu downloadMenu;
	
	public ReportsPage() {
		return;
	}

	/** Get URL variable from PageObject */
	public String getPageUrl() {
		return pageUrl;
	}
	
	/** Execute click action */
	public static ReportsPage click() {
		WebElement webelement = find(reportsButtonLocator);
		hoverOverElement(webelement);
		click(reportsButtonLocator);
		sleep(1000);
		takeScreenshot("ReportsPage opened");
		return new ReportsPage();
		//return UtilitiesMenu.reports();
	}

	/** Verification if logOutButton is visible on the page */
	public boolean isRecordsVisible() {
		return find(table).isDisplayed();
	}

	/** Return text from success message */
	public String getPageTitleText() {
		return find(message).getText();
	}

	public static ReportMenu reportMenu() {
		reportMenu = PageFactory.initElements(Driver.instance, ReportMenu.class);
		return reportMenu;
	}

	public static DownloadMenu download() {
		downloadMenu = PageFactory.initElements(Driver.instance, DownloadMenu.class);
		return downloadMenu;
		
	}

	public static ReportFilterBuilder filterButton() {
		doubleClick(filterbuttonlocator);
		//click(filterbuttonlocator);
		return new ReportFilter.ReportFilterBuilder();
	}
}
