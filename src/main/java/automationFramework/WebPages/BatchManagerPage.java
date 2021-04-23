package automationFramework.WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.NavigationBar.NavigateBar;

public class BatchManagerPage extends NavigateBar {
	
	Logger log = LoggerFactory.getLogger("BatchManagerPage.class");

	private static By batchManagerButtonLocator = By.xpath("//a[@id='nav-batch']");
	
	//Internal View
	//private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/dsq;dealerId=2425";
	
	//External View
	private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/batchui/#/pages/batches/uploaded";

	private By table = By.xpath("//a[@id='logoutlink']");
	private By message = By.cssSelector("#pagename");

	/** Get URL variable from PageObject*/
	public String getPageUrl() throws Exception {
		return pageUrl;
	}
	
	/** Execute click action*/
	public static BatchManagerPage click() {
		WebElement menu = find(batchManagerButtonLocator);
		hoverOverElement(menu);
		click(batchManagerButtonLocator);
		sleep(2000);
		takeScreenshot("BatchManagerPage opened");
		return new BatchManagerPage();
	}

	/** Verification if records are visible on the page */
	public boolean isRecordsVisible() {
		return find(table).isDisplayed();
	}

	/** Return text from success message */
	public String getSuccessMessageText() {
		return find(message).getText();
	}

}
