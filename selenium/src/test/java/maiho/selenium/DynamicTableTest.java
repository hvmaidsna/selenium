package maiho.selenium;

import org.testng.annotations.Test;

import base.BaseTest;

import java.text.NumberFormat;
import java.text.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DynamicTableTest extends BaseTest {
	private WebDriver driver;
	DynamicTablePage page;

	public DynamicTableTest() {
		// super("http://demo.guru99.com/test/web-table-element.php");
		// this.driver = BaseTest.getWebdriver();
		// page = new DynamicTablePage(true, driver);
	}

	@Test(priority = 0)
	public void testEasy() {
		page = new DynamicTablePage(true, driver);

		Assert.assertEquals(page.getColSize(), 5);
		Assert.assertEquals(page.getRowSize(), 26);
	}

	@Test(priority = 1)
	public void maxValueCurrentPrice() throws ParseException {
		int colSize = page.getColSize();
		int rowSize = page.getRowSize();
		Double curValue = 0.0, maxValue = 0.0;

		for (int i = 0; i < colSize; i++) {
			WebElement col = driver
					.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th[" + (i + 1) + "]"));

			if (col.getText().toString().contentEquals("Current Price (Rs)")) {
				for (int j = 0; j < rowSize; j++) {
					WebElement row = driver.findElement(
							By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[" + (j + 1) + "]/td[" + (i + 1) + "]"));

					System.out.println(
							"xpath index: " + "//*[@id=\"leftcontainer\"]/table/tbody/tr[" + (j + 1) + "]/td[" + (i + 1)
									+ "]" + "rowValue: " + row.getText().toString() + " - " + "toDouble: " + curValue);

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

		// Assert.assertEquals(maxValue, compareValue);
		System.out.println("maxValue: " + maxValue);
	}

	@Override
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
