package automationFramework.Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.NavigationBar.Utilities.ReportsPage;

public class DownloadMenu extends ReportsPage {

	Logger log = LoggerFactory.getLogger("DownloadMenu.class");
	
	private static By downLoadButtonLocator = By.xpath("//button[@id='button-export']");
	private static By pdfButtonLocator = By.xpath("//a[contains(text(),'PDF')]");
	private static By xlsButtonLocator = By.xpath("//a[contains(text(),'Excel')]");
	
	
	public static void xls() {
		WebElement menu = find(downLoadButtonLocator);
		hoverOverElement(menu);
		click(downLoadButtonLocator);
		sleep(1000);
		WebElement webelement = find(xlsButtonLocator);
		hoverOverElement(webelement);
		click(xlsButtonLocator);
		sleep(1000);
		takeScreenshot("xls downloading");
		
		download("pdf");
		
	}
	
	/** Execute click action*/
	public static void pdf() {
		WebElement menu = find(downLoadButtonLocator);
		hoverOverElement(menu);
		click(downLoadButtonLocator);
		sleep(1000);
		WebElement webelement = find(pdfButtonLocator);
		hoverOverElement(webelement);
		click(pdfButtonLocator);
		sleep(6000);
		
		takeScreenshot("pdf downloading");
		
		download("pdf");
	}

}
