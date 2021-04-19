package automationFramework.ReportPages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.NavigationBar.UtilitiesMenu;

public class StandardTransactionExportPage extends UtilitiesMenu {

	Logger log = LoggerFactory.getLogger("StandardTransactionExportPage.class");

	private By STEButtonLocator = By.linkText("Standard Transaction Export");
	
	//Internal View
	//private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/dsq;dealerId=2425";
	
	//External View
	private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/jrs-reports";

	private By table = By.xpath("//a[@id='logoutlink']");
	private By message = By.xpath("//h3[contains(text(),'Client Reports - Standard Transaction Export')]");

	/** Get URL variable from PageObject 
	 * @throws InterruptedException */
	public String getPageUrl() throws InterruptedException {
		return pageUrl;
	}
	
	/** Execute click action
	 * @throws InterruptedException */
	public StandardTransactionExportPage click() throws InterruptedException {
		//log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
		click(STEButtonLocator);
		Thread.sleep(1000);
		takeScreenshot("StandardTransactionExportPage opened");
		return new StandardTransactionExportPage();
	}

	/** Verification if logOutButton is visible on the page */
	public boolean isRecordsVisible() {
		return find(table).isDisplayed();
	}

	/** Return text from success message */
	public String getPageTitleText() {
		return find(message).getText();
	}
}
