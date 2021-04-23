package automationFramework.WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.NavigationBar.NavigateBar;

public class DealStatusQueuePage extends NavigateBar {
	
	Logger log = LoggerFactory.getLogger("DealStatusQueuePage.class");

	private static By dsqButtonLocator = By.xpath("//a[@id='nav-logbook']");
	
	//Internal View
	//private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/dsq;dealerId=2425";
	
	//External View
	private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/dsq";

	private By table = By.xpath("//a[@id='logoutlink']");
	private By message = By.cssSelector("#pagename");

	/** Get URL variable from PageObject */
	public String getPageUrl() throws InterruptedException {
		return pageUrl;
	}
	
	/** Execute click action after hovering */
	public static DealStatusQueuePage click() {
		WebElement menu = find(dsqButtonLocator);
		hoverOverElement(menu);
		sleep(1000);
		click(dsqButtonLocator);
		sleep(1000);
		takeScreenshot("DealStatusQueuePage opened");
		return new DealStatusQueuePage();
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
