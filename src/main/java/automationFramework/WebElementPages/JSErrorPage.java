package automationFramework.WebElementPages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.BasePageObject;

public class JSErrorPage extends BasePageObject {
	//Logger log = LoggerFactory.getLogger("JSErrorPage.class");

	private String pageUrl = "http://the-internet.herokuapp.com/javascript_error";

//	public JSErrorPage(WebDriver driver, Logger log) {
//		super(driver, log);
//	}

	/** Open JSErrorPage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

}
