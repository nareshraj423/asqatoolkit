package automationFramework.NavigationBar;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.Driver.Driver;

public class UtilitiesMenu extends NavigateBar {
	
	Logger log = LoggerFactory.getLogger("UtilitiesMenu.class");

	private By utilitiesButtonLocator = By.xpath("//a[@id='nav-utilities']");
	
	public static ReportsPage reportsPage;
	
	/** Execute click action
	 * @throws InterruptedException */
	public UtilitiesMenu click() throws InterruptedException {
		//log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
		click(utilitiesButtonLocator);
		Thread.sleep(1000);
		takeScreenshot("UtilitiesMenu opened");
		return new UtilitiesMenu();
	}

	public static ReportsPage reports() {
		reportsPage = PageFactory.initElements(Driver.instance, ReportsPage.class);
		return new ReportsPage();
		
	}

}
