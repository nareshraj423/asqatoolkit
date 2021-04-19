package automationFramework;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import automationFramework.Driver.Driver;
import automationFramework.WebPages.LoginPage;
import automationFramework.WebPages.SecureAreaPage;

public class Pages extends BasePageObject{
	
	public static LoginPage loginPage;
	public static SecureAreaPage secureAreaPage;
	
	@BeforeMethod
	public void init() throws Exception {
		//Open Login page
		secureAreaPage = Pages.loginPage().open().logIn("NAREGO00", "ApriL@2017");
	}

	public static LoginPage loginPage() {
		loginPage = PageFactory.initElements(Driver.instance, LoginPage.class);
		return loginPage;
	}
	
	public static SecureAreaPage secureAreaPage() {
		secureAreaPage = PageFactory.initElements(Driver.instance, SecureAreaPage.class);
		return secureAreaPage;
	}

}
