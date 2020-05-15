package maiho.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class guru99LoginTest {
	WebDriver driver;

	guru99LoginPage loginPage = new guru99LoginPage(driver);
	guru99HomePage homePage = new guru99HomePage(driver);

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "/Users/mba0298p/Documents/Software/Selenium/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test(priority = 0)
	public void resetTest() {
		loginPage = new guru99LoginPage(driver);
		loginPage.reset("mgr123", "mgr!23");
	}

	@Test(priority = 1)
	public void loginTest() {
		loginPage.login("mgr123", "mgr!23");
	}

	@Test(priority = 2)
	public void verifyMangeID() {
		homePage = new guru99HomePage(driver);

		Assert.assertTrue(homePage.getMangerID().contains("mgr123"));
	}
}
