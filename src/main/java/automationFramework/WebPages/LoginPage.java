package automationFramework.WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.BasePageObject;
import automationFramework.Pages;
import automationFramework.Driver.Driver;

public class LoginPage extends Pages {
	Logger log = LoggerFactory.getLogger("LoginPage.class");
	
	private String pageUrl = "https://ereg3ui.test.regusa.dtrts.com/#/login";

	private By message = By.xpath("//h2[contains(text(),'Reg & Title')]");
	private By usernameLocator = By.xpath("//input[@id='username']");
	private By passwordLocator = By.xpath("//input[@id='password']");
	private By logInButtonLocator = By.xpath("//button[@id='login-btn']");
	private By errorMessageLocator = By.id("flash");


	/** Open page with it's url */
	public LoginPage open() throws Exception {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		takeScreenshot("LoginPage opened");
		log.info("Page opened!");
		return new LoginPage();
	}

	/** Execute log in */
	public SecureAreaPage logIn(String username, String password) throws Exception {
		log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(logInButtonLocator);
		Thread.sleep(3000);
		takeScreenshot("SecureAreaPage opened");
		return new SecureAreaPage();
	}

	public void negativeLogIn(String username, String password) {
		log.info("Executing Negative LogIn with username [" + username + "] and password [" + password + "]");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(logInButtonLocator);
	}

	/** Wait for error message to be visible on the page */
	public void waitForErrorMessage() {
		waitForVisibilityOf(errorMessageLocator, 5);
	}

	/** Return text from success message */
	public String getSuccessMessageText() {
		return find(message).getText();
	}

	/** Return text from error message */
	public String getErrorMessageText() {
		return find(errorMessageLocator).getText();
	}

}
