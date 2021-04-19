package automationFramework.Driver;

import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
import util.ConfigReader;

public class Driver {
	Logger log; //= LoggerFactory.getLogger("Driver.class");

	private ConfigReader configReader;
	Properties prop;
	
	public static WebDriver instance;
	//public static Logger log;
	public String testSuiteName;
	public String testName;
	public String testMethodName;
	
//	private Driver(){
//	}

	@BeforeMethod(alwaysRun = true)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

//	@Before(order = 1)
//	public void launchBrowser() {
//		String browserName = prop.getProperty("browser");
//		driverFactory = new DriverFactory();
//		driver = driverFactory.init_driver(browserName);
//		
//	}
	
	@Parameters({"browser", "chromeProfile", "deviceName"})
	@BeforeMethod(alwaysRun = true)
	public void initialise(@Optional("Chrome") String browser, ITestContext ctx, @Optional("null") String profile,
			@Optional("null") String deviceName, Method method) {
		
		this.testName = ctx.getCurrentXmlTest().getName();
		this.testSuiteName = ctx.getSuite().getName();
		this.testMethodName = method.getName();
		
		log = LoggerFactory.getLogger(testName);

		BrowserDriverFactory factory = new BrowserDriverFactory(browser,log);
		if (profile != null) {
			instance = factory.createChromeWithProfile(profile);
		} else if (deviceName != null) {
			instance = factory.createChromeWithMobileEmulation(deviceName);
		} else {
			instance = factory.createDriver();
		}

		// This sleep here is for instructor only. Students don't need this here
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		instance.manage().deleteAllCookies();
		instance.manage().window().maximize();

	}
	
	@AfterMethod
	public void quitBrowser() {
		log.info("Close driver");
		instance.quit();
	}

//	@AfterMethod()
//	public void tearDown(Scenario scenario) {
//		if (scenario.isFailed()) {
//			// take screenshot:
//			String screenshotName = scenario.getName().replaceAll(" ", "_");
//			byte[] sourcePath = ((TakesScreenshot) instance).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(sourcePath, "image/png", screenshotName);
//
//		}
//	}

//	@Test
//	public void start() {
//		
//	}


}
