import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Html_auto {
	public WebDriver driver;

	@BeforeTest()

	public void login() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/inventory.html");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

	}

	@Test(priority = 1)
	public void sort_items_low_to_high() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();

		List<WebElement> thePricesList = driver.findElements(By.className("inventory_item_price"));

		List<Double> myNewEditedList = new ArrayList<>();
		for (int i = 0; i < thePricesList.size(); i++) {

			String price = thePricesList.get(i).getText();

			String editedPrice = price.replace("$", "  ");

			double val = Double.parseDouble(editedPrice.trim());
			myNewEditedList.add(val);

		}
		System.out.println("Sort Item low to high " + myNewEditedList);
		for (int k = 0; k < myNewEditedList.size(); k++) {
			boolean checkProcess = myNewEditedList.get(0) < myNewEditedList.get(myNewEditedList.size() - 1);
			Assert.assertEquals(checkProcess, true);
		}
	}
	
	@Test(priority = 2)
	public void sort_items_high_to_low() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")).click();

		List<WebElement> thePricesList1 = driver.findElements(By.className("inventory_item_price"));

		List<Double> myNewEditedList1 = new ArrayList<>();
		for (int j = 0; j < thePricesList1.size(); j++) {

			String price1 = thePricesList1.get(j).getText();

			String editedPrice1 = price1.replace("$", "  ");

			double val1 = Double.parseDouble(editedPrice1.trim());
			myNewEditedList1.add(val1);

		}
		System.out.println("Sort Item high to low " + myNewEditedList1);
		for (int k1 = 0; k1 < myNewEditedList1.size(); k1++) {
			boolean checkProcess1 = myNewEditedList1.get(0) > myNewEditedList1.get(myNewEditedList1.size() - 1);
			Assert.assertEquals(checkProcess1, true);
		}
	}

}
