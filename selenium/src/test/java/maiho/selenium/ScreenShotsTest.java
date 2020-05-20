package maiho.selenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;

public class ScreenShotsTest extends BaseTest {
	private WebDriver driver;

	@Test(enabled = false)
	@Parameters({ "destFolderPath", "srcFolderPath" })
	public void screenShotTest(String destFolderPath, String srcFolderPath) throws IOException {
		ScreenshotPage page = new ScreenshotPage(true, driver);
		
		String destFilePath = destFolderPath + "/v4.png";
		System.out.println("destFilePath: " + destFilePath);
		
		page.takeScreenShots(driver, destFilePath);
	}

	@Test(enabled = false)
	@Parameters({ "destFolderPath", "srcFolderPath" })
	public void screenShotTestByAshot(String destFolderPath, String srcFolderPath) throws IOException {
		ScreenshotPage page = new ScreenshotPage(true, driver);

		String destFilePath = destFolderPath + "/v4.jpg";
		System.out.println("destFilePath: " + destFilePath);

		page.takeScreenShotsByAshot(driver, destFilePath);
	}

	@Test(enabled = true)
	@Parameters({ "destFolderPath", "srcFolderPath" })
	public void elementScrShotTestByAshot(String destFolderPath, String srcFolderPath) throws IOException {
		ScreenshotPage page = new ScreenshotPage(true, driver);

		String destFilePath = destFolderPath + "/v5.jpg";
		System.out.println("destFilePath: " + destFilePath);
		
		if(page.getBaroneElement() != null) {
			System.out.println("getBaroneElement() successfully");
		}
		page.takeElementScreenShotsByAshot(driver, destFilePath, page.getBaroneElement());
	}

	@Override
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
