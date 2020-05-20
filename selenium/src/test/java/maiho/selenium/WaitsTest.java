package maiho.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class WaitsTest extends BaseTest {
	Waits waitClass;
	private WebDriver driver;

	public WaitsTest() {
		//super("http://demo.guru99.com/test/guru99home/");
	}

	@Test
	public void testFluentWait() {
		waitClass = new Waits(true, driver);
		
		WebElement element = waitClass.fluentWait(driver, 30, 5,
				By.xpath("//*[@id=\"rt-showcase\"]/div/div[1]/div/div/div/div/div[1]/div/div/h2/font"));

		Assert.assertTrue(element.getText().toString().toUpperCase().contentEquals("THIS IS A DEMO PAGE FOR TESTING"));
	}

	@Override
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
