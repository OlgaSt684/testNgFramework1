package class1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork {

	WebDriver driver;
	WebElement userName;
	WebElement password;
	WebElement loginButton;

	@BeforeMethod

	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void loginWithValidCredentials() {
		userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys("Admin");
		password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Hum@nhrm123");
		loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();

		WebElement logo = driver.findElement(By.xpath("//img[@alt='OrangeHRM']"));

		boolean actualResult;
		boolean expectedResult = true;

		if (logo.isDisplayed()) {
			actualResult = true;
		} else {
			actualResult = false;
		}
		AssertJUnit.assertEquals(actualResult, expectedResult);
		System.out.println("Hello!");
	}

	@Test(priority = 2)
	public void loginWithoutPassword() {
		userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys("Admin");
		//password = driver.findElement(By.id("txtPassword"));
		//password.sendKeys("Hum@nhrm123");
		loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();
		
		WebElement errorMessage=driver.findElement(By.xpath("//span[text()='Password cannot be empty']"));
		String actualText="Password cannot be empty";
		String expectedText=errorMessage.getText();
		AssertJUnit.assertEquals(actualText, expectedText, "Text is not match");
		System.out.println("The end!");
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}
}
