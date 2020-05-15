package maiho.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class guru99LoginPage {

	WebDriver driver;
	
	@FindBy(name="uid")
	WebElement name;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(name="btnReset")
	WebElement btnReset;
	
	public guru99LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**

     * This method allow to input data for UserID text-field

     * @param userID

     * @return

     */
	public void setUserID(String userID) {
		this.name.sendKeys(userID);
	}
	
	/**

     * This method allow to input data for Password text-field

     * @param password

     * @return

     */
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	
	/**

     * This method allow to tap on button Reset

     * @param

     * @return

     */
	public void clickReset() {
		this.btnReset.click();
	}
	
	/**

     * This method allow to tap on button Login

     * @param

     * @return

     */
	public void clickLogin() {
		this.btnLogin.click();
	}

    /**

     * This method allow to execute login action

     * @param userID

     * @param password

     * @return

     */
	public void login(String userID, String password) {
		this.setUserID(userID);
		this.setPassword(password);
		this.clickLogin();
	}

    /**

     * This method allow to execute reset action

     * @param userID

     * @param password

     * @return

     */
	public void reset(String userID, String password) {
		this.setUserID(userID);
		this.setPassword(password);
		this.clickReset();
	}
}
