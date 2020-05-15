package maiho.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class guru99HomePage {

	WebDriver driver;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
	WebElement mangerID;
	
	public guru99HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**

     * This method allow to input data for UserID text-field

     * @param 

     * @return text of mangerID

     */
	public String getMangerID() {
		return mangerID.getText().toString();
	}
}
