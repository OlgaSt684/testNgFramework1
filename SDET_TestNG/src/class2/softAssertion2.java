package class2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertion2 {
	WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void validLogin() {
		String titleExpected = "Human Recource Managment System";
		String titleActual = driver.getTitle();

		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(titleActual, titleExpected);

		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Hum@nhrm123");
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();

		WebElement welcomeText = driver.findElement(By.xpath("//a[@id='welcome']"));
		String text=welcomeText.getText();
		AssertJUnit.assertFalse(welcomeText.isDisplayed());
				
		String expectedText="Welcome admin123";
		AssertJUnit.assertEquals(text, expectedText);
		
		System.out.println("My statement after all the assertion");
		
		softAssert.assertAll();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
