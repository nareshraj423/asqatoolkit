package automationFramework.WebElementPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.BasePageObject;

public class KeyPressesPage extends BasePageObject {
	Logger log = LoggerFactory.getLogger("KeyPressesPage.class");

	private String pageUrl = "http://the-internet.herokuapp.com/key_presses";

	private By body = By.xpath("//body");
	private By resultTextLocator = By.id("result");

//	public KeyPressesPage(WebDriver driver, Logger log) {
//		super(driver, log);
//	}

	/** Open KeyPressesPage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	/** Press given key while on this page */
	public void pressKey(Keys key) {
		log.info("Pressing " + key.name());
		pressKey(body, key);
	}

	/** Get result text */
	public String getResultText() {
		String result = find(resultTextLocator).getText();
		log.info("Result text: " + result);
		return result;
	}

}
