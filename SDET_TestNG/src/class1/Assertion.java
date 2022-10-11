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

public class Assertion {

	WebDriver driver; // <--instance variable

	@BeforeMethod
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 1, enabled = true)
	public void validLogin() {

		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Hum@nhrm123");
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();

		WebElement welcomeText = driver.findElement(By.xpath("//a[@id='welcome']"));
		AssertJUnit.assertTrue(welcomeText.isDisplayed());
		System.out.println("My assertion is passed");

	}

	@Test(priority = 2, enabled = false)
	public void validationOfTitle() {
		String actualValue = "Human Management System";
		String expectedText = driver.getTitle();
		AssertJUnit.assertEquals(actualValue, expectedText, "value are not same");
		System.out.println("I am executing after assertion");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
