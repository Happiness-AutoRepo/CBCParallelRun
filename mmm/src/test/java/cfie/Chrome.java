package cfie;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Chrome {

	WebDriver driver;
	public static final String USERNAME = "maratmetoff";
	public static final String ACCESS_KEY = "2ef1dbe1-1cd9-4dde-bdfb-d0e720163b83";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	@BeforeClass
	public void beforeTest() throws MalformedURLException {
		
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "55");

		driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}
	
	@Test
	public void ChromeTest() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		FileInputStream input = new FileInputStream("./src/test/resources/TestData/Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(input);
		Sheet sheet = workbook.getSheetAt(0);
		int rowNum = sheet.getPhysicalNumberOfRows();
		
		Row row = sheet.getRow(1);
		int cellNum = row.getPhysicalNumberOfCells();
		
		Cell cell = row.getCell(1);
		
		driver.findElement(By.id("lst-ib")).sendKeys(cell.getStringCellValue() + Keys.ENTER);
		Thread.sleep(3000);
		driver.quit();
		
		input.close();
		workbook.close();
	}
	
}
