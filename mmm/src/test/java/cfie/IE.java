package cfie;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IE {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.ie.driver",
				"./src/test/resources/drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}

	@Test
	public void IE() throws InterruptedException {
		
		try {
			driver.findElement(By.id("lst-ib")).sendKeys("How much is 5 + 5?");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(4000);
		driver.quit();
	}
}
