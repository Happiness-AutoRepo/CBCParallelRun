package mmm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Regression {

	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}
	
	@Test(groups = {"Regression"})
	public void f() throws InterruptedException {
		driver.findElement(By.id("lst-ib")).sendKeys("How much is 5 + 5?");
		Thread.sleep(4000);
	}

	@Test
	public void f1() {

		System.out.println("Functional");

	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
