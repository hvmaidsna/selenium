package maiho.selenium;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicTablePage extends BasePage{

	//WebDriver driver;
	private final String url = "http://demo.guru99.com/test/web-table-element.php";
	
	@FindBy(xpath="//*[@id=\"leftcontainer\"]/table/thead/tr/th")
	List<WebElement> col;
	
	@FindBy(xpath="//*[@id=\"leftcontainer\"]/table/tbody/tr")
	List<WebElement> row;
	
	public DynamicTablePage(boolean isOpenUrl, final WebDriver driver) {
		//this.driver = driver;
		super(isOpenUrl, driver);
	}
	
	public int getColSize() {
		return col.size();
	}
	
	public int getRowSize() {
		return row.size();
	}

	@Override
	protected void openUrl(final WebDriver driver) {
		driver.get(this.url);
		PageFactory.initElements(driver, this);
	}

}
