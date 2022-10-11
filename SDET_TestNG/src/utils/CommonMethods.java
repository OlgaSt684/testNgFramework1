package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonMethods {

	public static WebDriver driver;

	@BeforeMethod(alwaysRun = true) // pre condition
	public void openBrowser() {
		
		configReader.readProperties("C:\\Users\\andre\\eclipse-workspace\\SDET_TestNG\\src\\config\\config.properties");
		
		switch (configReader.getPropertyValue("browser")) {
		case "chrome":

			System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.out.println("Browser not available");
			break;

		default:
			throw new RuntimeException("Invalid browser name");
		}

		driver.get(configReader.getPropertyValue("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod(alwaysRun = true) // post condition
	public void tearDown() {
		driver.quit();
	}

}
