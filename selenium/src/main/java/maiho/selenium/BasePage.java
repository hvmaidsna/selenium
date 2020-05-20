package maiho.selenium;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
	public BasePage(boolean isOpenUrl, final WebDriver driver) {
		if (isOpenUrl) {
			openUrl(driver);
		}
	}

	protected abstract void openUrl(final WebDriver driver);

	/*
	 * public static void explicitWait(WebDriver driver, int time, By locator) {
	 * WebDriverWait wait = new WebDriverWait(driver, time);
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); }
	 */
}
