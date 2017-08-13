package cfie;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IE {

	WebDriver driver;
	public static final String USERNAME = "maratmetoff";
	public static final String ACCESS_KEY = "2ef1dbe1-1cd9-4dde-bdfb-d0e720163b83";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	@BeforeClass
	public void beforeTest() throws MalformedURLException {
		
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "11");

		driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}
	
	@Test
	public void IETest() throws InterruptedException {
		
		driver.findElement(By.id("lst-ib")).sendKeys("How much is 5 + 5?");
		Thread.sleep(4000);
		driver.quit();
	}
	
}