package maiho.selenium;

import org.testng.annotations.Test;

import base.BaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class guru99LoginTest extends BaseTest {
	private WebDriver driver;
	guru99LoginPage loginPage;
	guru99HomePage homePage;

	public guru99LoginTest() {
		// this.driver = BaseTest.getWebdriver();
		// loginPage = new guru99LoginPage(true, driver);
		// homePage = new guru99HomePage(false, driver);
	}

	@Test(priority = 0)
	public void resetTest() {
		loginPage = new guru99LoginPage(true, driver);
		loginPage.reset("mgr123", "mgr!23");
	}

	@Test(priority = 1)
	public void loginTest() {
		loginPage.login("mgr123", "mgr!23");

		homePage = new guru99HomePage(false, driver);
		PageFactory.initElements(driver, homePage);

	}

	@Test(priority = 2)
	public void verifyMangeID() {
		System.out.println("homePage.getMangerID(): " + homePage.getMangerID());
		Assert.assertTrue(homePage.getMangerID().contains("mgr123"));
	}

	@Override
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
