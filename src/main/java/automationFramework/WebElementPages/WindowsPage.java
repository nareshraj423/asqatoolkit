package automationFramework.WebElementPages;

import org.openqa.selenium.By;
import automationFramework.BasePageObject;

public class WindowsPage extends BasePageObject {
	//Logger log = LoggerFactory.getLogger("DropdownPage.class");

	private By clickHereLinkLocator = By.linkText("Click Here");

//	public WindowsPage(WebDriver driver, Logger log) {
//		super(driver, log);
//	}

	/** Click 'Click Here' link to open new window */
	public void openNewWindow() {
		log.info("Clicking 'Click Here' link");
		click(clickHereLinkLocator);
	}

	/** Find page with title "New Window" and switch to it */
	public NewWindowPage switchToNewWindowPage() {
		log.info("Looking for 'New Window' page");
		switchToWindowWithTitle("New Window");
		return new NewWindowPage();
	}

}
