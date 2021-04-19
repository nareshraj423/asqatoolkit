package automationFramework.WebPages;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.BasePageObject;
import automationFramework.Pages;

public class SecureAreaPage extends Pages {
	Logger log = LoggerFactory.getLogger("SecureAreaPage.class");
	
	//Internal View
	//private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/dsq;dealerId=2425";
	
	//External View
	private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/dsq";

	private By logOutButton = By.xpath("//a[@id='logoutlink']");
	private By message = By.cssSelector("#pagename");

//	public SecureAreaPage(WebDriver driver, Logger log) {
//		super(driver, log);
//	}

	/** Get URL variable from PageObject 
	 * @throws InterruptedException */
	public String getPageUrl() throws InterruptedException {
		return pageUrl;
	}

	/** Verification if logOutButton is visible on the page */
	public boolean isLogOutButtonVisible() {
		return find(logOutButton).isDisplayed();
	}

	/** Return text from success message */
	public String getPageTitleText() {
		return find(message).getText();
	}

}
