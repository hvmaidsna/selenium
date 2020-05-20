package maiho.selenium;

import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits extends BasePage{
	private final String url = "http://demo.guru99.com/test/guru99home/";
	
	@FindBy(xpath = "//*[@id=\"rt-showcase\"]/div/div[1]/div/div/div/div/div[1]/div/div/h2/font")
	WebElement fluentElement;
	
	public Waits(boolean isOpenUrl, WebDriver driver) {
		super(isOpenUrl, driver);
	}

	public void implicitWait(WebDriver driver, int time, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(time, unit);
	}

	public WebElement explicitWait(WebDriver driver, int time, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return driver.findElement(locator);
	}

	public WebElement fluentWait(WebDriver driver, int timeout, int pollingTime, final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return element;
	}

	@Override
	protected void openUrl(WebDriver driver) {
		driver.get(this.url);
		PageFactory.initElements(driver, this);
	}

}
