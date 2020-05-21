package maiho.selenium;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotPage extends BasePage {
	private final String url = "http://demo.guru99.com/V4/";

	@FindBy(xpath = "/html/body/h4")
	WebElement barone;

	public ScreenshotPage(boolean isOpenUrl, WebDriver driver) {
		super(isOpenUrl, driver);
	}

	@Override
	protected void openUrl(WebDriver driver) {
		driver.get(this.url);
		PageFactory.initElements(driver, this);
	}

	public void takeScreenShots(WebDriver driver, String filePath) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File desFile = new File(filePath);
		FileHandler.copy(srcFile, desFile);
	}

	public void takeScreenShotsByAshot(WebDriver driver, String filePath) throws IOException {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "jpg", new File(filePath));
	}

	public void takeElementScreenShotsByAshot(WebDriver driver, String filePath, WebElement element)
			throws IOException {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver, element);
		ImageIO.write(screenshot.getImage(), "jpg", new File(filePath));
	}

	public boolean compare2Image(WebDriver driver, String filePath)
			throws IOException {
		Screenshot screenshot = new AShot().takeScreenshot(driver);
		
		BufferedImage expectedImage = ImageIO.read(new File(filePath));
		
		BufferedImage actualImage = screenshot.getImage();
		
		ImageDiffer differ = new ImageDiffer();
		ImageDiff  diff = differ.makeDiff(expectedImage, actualImage);
		
		return diff.hasDiff();
	}

	public WebElement getBaroneElement() {
		return barone;
	}

}
