package maiho.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DynamicTable {
	private WebDriver driver;

	@Test
	public void testEasy() {
		List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		
		List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
		
		Assert.assertEquals(col.size(), 5);
		Assert.assertEquals(row.size(), 26);
		
		System.out.println("col: " + col.size());
		System.out.println("row: " + row.size());
	}

	@Test
	public void maxValueCurrentPrice() throws ParseException {
		List<WebElement> cols = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
		Double curValue = 0.0, maxValue = 0.0;
		
		for (int i = 0; i < cols.size(); i++) {
			WebElement col = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th[" + (i+1) + "]"));
			
			if(col.getText().toString().contentEquals("Current Price (Rs)")) {
				for (int j = 0; j < rows.size(); j++) {
					WebElement row = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+ (j+1) +"]/td["+(i+1)+"]"));
					
					System.out.println("xpath index: " + "//*[@id=\"leftcontainer\"]/table/tbody/tr["+ (j+1) +"]/td["+(i+1)+"]" + 
										"rowValue: " + row.getText().toString() + " - " + "toDouble: " + curValue);
					
					NumberFormat f = NumberFormat.getNumberInstance();
					Number m = f.parse(row.getText().toString());
					
					curValue = m.doubleValue();
					
					if (curValue > maxValue) {
						maxValue = curValue;
					}
				}
				break;
			}
		}
		
		//Assert.assertEquals(maxValue, compareValue);
		System.out.println("maxValue: " + maxValue);
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "/Users/mba0298p/Documents/Software/Selenium/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/web-table-element.php");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
