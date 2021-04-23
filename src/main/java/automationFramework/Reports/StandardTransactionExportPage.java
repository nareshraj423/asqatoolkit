package automationFramework.Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.NavigationBar.UtilitiesMenu;

public class StandardTransactionExportPage extends UtilitiesMenu {

	Logger log = LoggerFactory.getLogger("StandardTransactionExportPage.class");

	private static By standTransExportButtonLocator = By.linkText("Standard Transaction Export");
	
	//Internal View
	//private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/dsq;dealerId=2425";
	
	//External View
	private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/pages/jrs-reports";

	private By table = By.xpath("//a[@id='logoutlink']");
	private By message = By.xpath("//h3[contains(text(),'Client Reports - Standard Transaction Export')]");

	
	public StandardTransactionExportPage() {
		//click(standTransExportButtonLocator);
		return;
	}

	/** Get URL variable from PageObject */
	public String getPageUrl() throws Exception {
		return pageUrl;
	}
	
	/** Execute click action
	 * @throws InterruptedException */
	public static StandardTransactionExportPage click() {
		WebElement webelement = find(standTransExportButtonLocator);
		hoverOverElement(webelement);
		click(standTransExportButtonLocator);
		sleep(1000);
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
