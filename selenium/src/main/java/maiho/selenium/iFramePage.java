package maiho.selenium;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iFramePage extends BasePage{
	//WebDriver driver;
	private final String url = "http://demo.guru99.com/test/guru99home/";
	
	@FindBy(xpath="//*[@src=\"Jmeter720.png\"]")
	WebElement iFrame;
	
	public iFramePage(boolean isOpenUrl, WebDriver driver) {
		//this.driver = driver;
		super(isOpenUrl, driver);
	}
	
	public void clickFrame() {
		iFrame.click();
	}

	@Override
	protected void openUrl(WebDriver driver) {
		driver.get(this.url);
		PageFactory.initElements(driver, this);
	}
}
