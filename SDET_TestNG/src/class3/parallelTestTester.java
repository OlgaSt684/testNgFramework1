package class3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class parallelTestTester extends CommonMethods {

	@DataProvider
	public Object[][] loginData() {
		Object[][] data = new Object[3][2];
		/*
		 * 2D Array.Data for three users. Three rows- number of user. Two
		 * columns-username/password.
		 */

		data[0][0] = "Admin";
		data[0][1] = "Hum@nhrm123";
		data[1][0] = "Admin";
		data[1][1] = "Hum@nhrm123";
		data[2][0] = "Admin";
		data[2][1] = "Hum@nhrm123";

		return data;
	}

	
	@Test(dataProvider = "loginData")
	public void validLogin1(String username, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement welcomeAttribute = driver.findElement(By.xpath("//a[@id='welcome']"));
		Assert.assertTrue(welcomeAttribute.isDisplayed());

	}

	@Test(dataProvider = "loginData")
	public void validLogin2(String username, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement welcomeAttribute = driver.findElement(By.xpath("//a[@id='welcome']"));
		Assert.assertTrue(welcomeAttribute.isDisplayed());

	}

	@Test(dataProvider = "loginData")
	public void validLogin3(String username, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement welcomeAttribute = driver.findElement(By.xpath("//a[@id='welcome']"));
		Assert.assertTrue(welcomeAttribute.isDisplayed());

	}


}
