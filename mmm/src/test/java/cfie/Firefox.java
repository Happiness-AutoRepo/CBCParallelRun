package cfie;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Firefox {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver",
				"./src/test/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}

	@Test
	public void Firefox() throws InterruptedException {

		driver.findElement(By.id("lst-ib")).sendKeys("How much is 5 + 5?");
		Thread.sleep(4000);
		driver.quit();
	}
}
