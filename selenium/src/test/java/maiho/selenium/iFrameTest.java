package maiho.selenium;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class iFrameTest extends BaseTest {
	WebDriver driver;
	iFramePage page;

	public iFrameTest() {
		// this.driver = BaseTest.getWebdriver();
		// page = new iFramePage(true, driver);
	}

	@Test
	public void testIFrame() {
		page = new iFramePage(true, driver);

		this.driver.switchTo().frame("a077aa5e");
		page.clickFrame();

		ArrayList<String> windows = new ArrayList<String>(this.driver.getWindowHandles());
		this.driver.switchTo().window(windows.get(1));

		Assert.assertTrue(this.driver.getCurrentUrl().toString()
				.contentEquals("https://www.guru99.com/live-selenium-project.html"));

		this.driver.close();
		this.driver.switchTo().window(windows.get(0));

		Assert.assertTrue(
				this.driver.getCurrentUrl().toString().contentEquals("http://demo.guru99.com/test/guru99home/"));
	}

	@Override
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
