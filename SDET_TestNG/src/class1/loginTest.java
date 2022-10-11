package class1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginTest {
	// User story(US) - 54321
	// As an admin user you should be able to login with valid credentials

	WebDriver driver; // <--instance variable

	@BeforeMethod
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test (priority = 2)
	public void validateDashboardPage() {
		System.out.println("Verifying the dashboard page");
	}

	@Test (priority=1)
	public void validLogin() {
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Hum@nhrm123");
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();

		WebElement welcomeText = driver.findElement(By.xpath("//a[@id='welcome']"));

		if (welcomeText.isDisplayed()) {
			System.out.println("Test Case is valid and pass");
		} else {
			System.out.println("Test case is invalid and fail");
		}
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
