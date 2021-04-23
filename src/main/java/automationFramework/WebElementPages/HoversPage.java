package automationFramework.WebElementPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.BasePageObject;

public class HoversPage extends BasePageObject {
	Logger log = LoggerFactory.getLogger("HoversPage.class");

	private String pageUrl = "http://the-internet.herokuapp.com/hovers";

	private By avatarLocator = By.xpath("//div[@class='figure']");
	private By viewProfileLinkLocator = By.xpath(".//a[contains(text(),'View profile')]");


	/** Open HoversPage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	/** Open specified user profile */
	public void openUserProfile(int i) {
		List<WebElement> avatars = findAll(avatarLocator);
		WebElement specifiedUserAvatar = avatars.get(i - 1);
		hoverOverElement(specifiedUserAvatar);
		specifiedUserAvatar.findElement(viewProfileLinkLocator).click();
	}
}
