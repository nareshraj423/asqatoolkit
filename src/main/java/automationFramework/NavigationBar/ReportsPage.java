package automationFramework.NavigationBar;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.Driver.Driver;
import automationFramework.ReportPages.ReportMenu;
import automationFramework.ReportPages.StandardTransactionExportPage;
import automationFramework.WebPages.DealStatusQueuePage;
import automationFramework.WebPages.HelpPage;

public class ReportsPage extends NavigateBar {

	Logger log = LoggerFactory.getLogger("ReportsPage.class");

	private By reportsButtonLocator = By.xpath("//a[@id='nav-reports']");
	
	//Internal View
	//private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/dsq;dealerId=2425";
	
	//External View
	private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/jrs-reports";

	private By table = By.xpath("//a[@id='logoutlink']");
	private By message = By.xpath("//h3[contains(text(),'Client Reports')]");

	private ReportMenu reportMenu;

	/** Get URL variable from PageObject 
	 * @throws InterruptedException */
	public String getPageUrl() throws InterruptedException {
		return pageUrl;
	}
	
	/** Execute click action
	 * @throws InterruptedException */
	public ReportsPage click() throws InterruptedException {
		//log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
		click(reportsButtonLocator);
		Thread.sleep(2000);
		takeScreenshot("ReportsPage opened");
		return new ReportsPage();
	}

	/** Verification if logOutButton is visible on the page */
	public boolean isRecordsVisible() {
		return find(table).isDisplayed();
	}

	/** Return text from success message */
	public String getPageTitleText() {
		return find(message).getText();
	}

	public ReportMenu reportMenu() {
		reportMenu = PageFactory.initElements(Driver.instance, ReportMenu.class);
		return reportMenu;
	}
}
