package automationFramework.WebPages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.NavigationBar.NavigateBar;

public class BatchManagerPage extends NavigateBar {
	
	Logger log = LoggerFactory.getLogger("BatchManagerPage.class");

	private By batchManagerButtonLocator = By.partialLinkText("BatchManag");
	
	//Internal View
	//private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/dsq;dealerId=2425";
	
	//External View
	private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/dsq";

	private By table = By.xpath("//a[@id='logoutlink']");
	private By message = By.cssSelector("#pagename");

	/** Get URL variable from PageObject 
	 * @throws InterruptedException */
	public String getPageUrl() throws InterruptedException {
		return pageUrl;
	}
	
	/** Execute click action
	 * @throws InterruptedException */
	public DealStatusQueuePage click() throws InterruptedException {
		//log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
		click(batchManagerButtonLocator);
		Thread.sleep(1000);
		takeScreenshot("BatchManagerPage opened");
		return new DealStatusQueuePage();
	}

	/** Verification if records are visible on the page */
	public boolean isRecordsVisible() {
		return find(table).isDisplayed();
	}

	/** Return text from success message */
	public String getPageTitleText() {
		return find(message).getText();
	}

}
