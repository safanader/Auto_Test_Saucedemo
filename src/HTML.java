import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML {

	public WebDriver driver;

	@BeforeTest
	
	public void login() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://github.com/login");
		driver.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("t12345678@");
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[11]")).click();
	
	}
	
	@Test()
	public void Test_the_Title() {
		String actualtitleName = driver.getTitle();
		String expectedtitleName = "GitHub";
		Assert.assertEquals(actualtitleName, expectedtitleName);
	}
	
	@Test()
	public void Test_the_Logout_Process() {
		System.out.println("logged out");
	}
//	@Test()
//	public void Test_the_existanse_of_the_user_name() {
//		
//	}
}
