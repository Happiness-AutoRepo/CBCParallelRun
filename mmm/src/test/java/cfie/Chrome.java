package cfie;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Chrome {

	WebDriver driver;

	@BeforeClass
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}
	
	@Test
	public void Chrome() throws InterruptedException {
		
		driver.findElement(By.id("lst-ib")).sendKeys("How much is 5 + 5?");
		Thread.sleep(4000);
		driver.quit();
	}
	
}
