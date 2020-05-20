package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
	private WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void beforeTest(String browser) {
		System.out.println("beforeTest is called");
		switch (browser) {
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "/Users/mba0298p/Documents/Software/Selenium/geckodriver");
			driver = new FirefoxDriver();
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "/Users/mba0298p/Documents/Software/Selenium/chromedriver");
			driver = new ChromeDriver();
			break;
		default:
			break;
		}

		if (driver != null) {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			setDriver(driver);
		}
	}

	@AfterClass
	public void afterTest() {
		if (driver != null) {
			driver.quit();
			driver = null;
			setDriver(driver);
		}
	}

	public WebDriver getWebdriver() {
		return driver;
	}
	
	public abstract void setDriver(WebDriver driver);
}
