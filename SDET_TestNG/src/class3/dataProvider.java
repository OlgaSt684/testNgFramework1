package class3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.*;

public class dataProvider {

	WebDriver driver;
	
    @DataProvider
	public Object[][] loginData() {
		Object[][] data = new Object[3][2];
		/*
		 * 2D Array.Data for three users. 
		 * Three rows- number of user. Two columns-username/password.
		 */

		data[0][0]="Admin2";
		data[0][1]="Hum@nhrm123";
		data[1][0]="Admin";
		data[1][1]="Hum@nhrm123";
		data[2][0]="Admin";
		data[2][1]="Hum@nhrm13";
		
		return data;
	}

    @BeforeMethod (alwaysRun = true) // pre condition
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}

	@Test (dataProvider = "loginData")
	public void validLogin(String username, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement welcomeAttribute = driver.findElement(By.xpath("//a[@id='welcome']"));
		Assert.assertTrue(welcomeAttribute.isDisplayed());
		
		
	}
	
	@AfterMethod(alwaysRun = true) // post condition
	public void tearDown() {
		driver.quit();
	}
	

}
