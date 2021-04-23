package automationFramework.WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.NavigationBar.NavigateBar;

public class TransactionsPage extends NavigateBar {
	Logger log = LoggerFactory.getLogger("TransactionsPage.class");

	private static By transactionsButtonLocator = By.partialLinkText("Transactio");
	
	//Internal View
	//private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/dsq;dealerId=2425";
	
	//External View
	private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/deal-start";

	private By table = By.xpath("//a[@id='logoutlink']");
	private By message = By.xpath("//h4[contains(text(),'Setup')]");

	/** Get URL variable from PageObject 
	 * @throws InterruptedException */
	public String getPageUrl() throws InterruptedException {
		return pageUrl;
	}
	
	/** Execute click action */
	public static TransactionsPage click() {
		WebElement menu = find(transactionsButtonLocator);
		hoverOverElement(menu);
		click(transactionsButtonLocator);
		sleep(1000);
		takeScreenshot("TransactionsPage opened");
		return new TransactionsPage();
	}

	/** Verification if sections are visible on the page */
	public boolean isSectionsVisible() {
		return find(table).isDisplayed();
	}

	/** Return text from success message */
	public String getPageTitleText() {
		return find(message).getText();
	}
}
