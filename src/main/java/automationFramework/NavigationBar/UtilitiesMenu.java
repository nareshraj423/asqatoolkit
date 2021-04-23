package automationFramework.NavigationBar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.Driver.Driver;
import automationFramework.NavigationBar.Utilities.ReportsPage;

public class UtilitiesMenu extends NavigateBar {
	
	Logger log = LoggerFactory.getLogger("UtilitiesMenu.class");

	private static By utilitiesButtonLocator = By.xpath("//a[@id='nav-utilities']");
	
	public static ReportsPage reportsPage;
	
	/** Execute click action*/
	public static UtilitiesMenu click() {
		WebElement menu = find(utilitiesButtonLocator);
		hoverOverElement(menu);
		click(utilitiesButtonLocator);
		sleep(1000);
		takeScreenshot("UtilitiesMenu opened");
		return new UtilitiesMenu();
	}

	public static ReportsPage reports() {
		reportsPage = PageFactory.initElements(Driver.instance, ReportsPage.class);
		return new ReportsPage();
		
	}

}
