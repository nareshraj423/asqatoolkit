package automationFramework.NavigationBar;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserProfileMenu extends NavigateBar {
	
	Logger log = LoggerFactory.getLogger("UtilitiesMenu.class");
	
	private By userProfileLocator = By.xpath("//a[@id='nav-username-dd']");
	private By myProfileLocator = By.xpath("");
	private By logoutButtonLocator = By.xpath("//a[@id='logoutlink']");
	
	public void myProfile() {
		// click user-profile button.
		click(userProfileLocator);
		sleep(2000);
		// click my profile button.
		click(myProfileLocator);		
	}

	public void logout() {
		// click user-profile button.
		click(userProfileLocator);
		sleep(2000);
		// click log-out button.
		click(logoutButtonLocator);		
	}

}
