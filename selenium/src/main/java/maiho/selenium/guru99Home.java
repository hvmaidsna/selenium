package maiho.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class guru99Home {

	WebDriver driver;
	
	@FindBy(name="uid")
	WebElement name;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(name="btnReset")
	WebElement btnReset;
	
	public guru99Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserID(String userID) {
		this.name.sendKeys(userID);
	}
	
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickReset() {
		this.btnReset.click();
	}
	
	public void clickLogin() {
		this.btnLogin.click();
	}
	
	
}
