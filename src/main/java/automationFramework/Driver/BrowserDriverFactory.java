package automationFramework.Driver;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriverFactory {

	public Logger log = LoggerFactory.getLogger("BrowserDriverFactory.class");
	
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;

	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}

	public WebDriver createDriver() {
		// Create driver
		log.info("Create driver: " + browser);

		switch (browser) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			
			String downloadFilepath = "C:\\Users\\NGOPISHETT\\git\\asqatoolkit\\test-output\\downloads\\";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.prompt_for_download", false);
			chromePrefs.put("download.default_directory", downloadFilepath);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			
			driver.set(new ChromeDriver(chromeOptions));
			break;

		case "firefox":
			//System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;

		case "chromeheadless":
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOption = new ChromeOptions();
			Map<String, Object> pref = new HashMap<String, Object>();
			pref.put("download.prompt_for_download", false);
			chromeOption.setExperimentalOption("prefs", pref);
			chromeOption.addArguments("--headless");
			driver.set(new ChromeDriver(chromeOption));
			break;

		case "firefoxheadless":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			//WebDriverManager.gecko().setup();
			FirefoxBinary firefoxBinary = new FirefoxBinary();
			firefoxBinary.addCommandLineOptions("--headless");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setBinary(firefoxBinary);
			driver.set(new FirefoxDriver(firefoxOptions));
			break;

//		case "phantomjs":
//			System.setProperty("phantomjs.binary.path", "src/main/resources/phantomjs.exe");
//			WebDriverManager.chromedriver().setup();
//			driver.set(new PhantomJSDriver());
//			break;
//
//		case "htmlunit":
//			driver.set(new HtmlUnitDriver());
//			break;

		default:
			System.out.println("Do not know how to start: " + browser + ", starting chrome.");
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		}

		return driver.get();
	}

	public WebDriver createChromeWithProfile(String profile) {
		log.info("Starting chrome driver with profile: " + profile);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("user-data-dir=src/main/resources/Profiles/" + profile);

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver.set(new ChromeDriver(chromeOptions));
		return driver.get();
	}

	public WebDriver createChromeWithMobileEmulation(String deviceName) {
		log.info("Starting driver with " + deviceName + " emulation]");
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", deviceName);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver.set(new ChromeDriver(chromeOptions));
		return driver.get();
	}
}
