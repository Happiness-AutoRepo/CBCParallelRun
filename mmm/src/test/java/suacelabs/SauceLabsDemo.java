package suacelabs;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsDemo {
	
	//https://wiki.saucelabs.com/display/DOCS/Example+Selenium+Scripts+for+Automated+Website+Tests
	//https://wiki.saucelabs.com/display/DOCS/Java+Test+Setup+Example

	public static final String USERNAME = "maratmetoff";
	public static final String ACCESS_KEY = "2ef1dbe1-1cd9-4dde-bdfb-d0e720163b83";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "11");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

		driver.get("https://letskodeit.teachable.com/p/practice");
		System.out.println("title of page is: " + driver.getTitle());

		Thread.sleep(3000);

		driver.quit();
	}
}