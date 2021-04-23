package automationFramework.WebElementPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.NavigationBar.NavigateBar;

public class ComboBoxPage extends NavigateBar {
	static Logger log = LoggerFactory.getLogger("ComboBoxPage.class");

	private static By comboboxLocator = By.xpath("//input[@role='combobox' and @type='text']");
	//private By logOutButton = By.xpath("//a[@id='logoutlink']");
	//private By message = By.cssSelector("#pagename");

	/** Verification if combo-box box is visible on the page */
	public boolean isComboBoxVisible() {
		return find(comboboxLocator).isDisplayed();
	}
	
	/** Execute search */
	public static NavigateBar search(String clientName) {
		log.info("Executing search with client Name or ID [" + clientName + "]");
		pressKey(comboboxLocator, Keys.CLEAR);
		type(clientName, comboboxLocator);
		//pressKeyWithActions(Keys.DOWN);
		takeScreenshot("Client: " + clientName + "displayed");
		pressKeyWithActions(Keys.ENTER);
		return new NavigateBar();
	}

	public NavigateBar negativeSearch(String clientName) throws Exception {
		log.info("Executing search with client Name or ID [" + clientName + "]");
		pressKey(comboboxLocator, Keys.CLEAR);
		type(clientName, comboboxLocator);
		pressKeyWithActions(Keys.ENTER);
		Thread.sleep(1000);
		takeScreenshot("SecureAreaPage opened");
		return this;
	}

	/** Wait for error message to be visible on the page */
	public void waitForErrorMessage() {
		//waitForVisibilityOf(errorMessageLocator, 5);
	}

	/** Return text from success message */
	public void getSuccessMessageText() {
		//return find(message).getText();
	}

	public void getErrorMessageText() {
		//return find(errorMessageLocator).getText();
	}

	/** This method selects given option from combobox */
	public ComboBoxPage selectOption(String text) {
		log.info("Selecting option " + text + " from dropdown");
		WebElement dropdownElement = find(comboboxLocator);
		Select dropdown = new Select(dropdownElement);

		// There are three ways to use Select class
		// #1
		//dropdown.selectByIndex(i);

		// #2
		//dropdown.selectByValue("" + i);

		// #3
		dropdown.selectByVisibleText("text");
		 
		 return this;
	}

	/** This method returns selected option in dropdown as a string */
	public String getSelectedOption() {
		WebElement dropdownElement = find(comboboxLocator);
		Select dropdown = new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		log.info(selectedOption + " is selected in dropdown");
		return selectedOption;
	}

}
