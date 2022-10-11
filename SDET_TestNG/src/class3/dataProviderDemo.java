package class3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.CommonMethods;
import utils.configReader;

public class dataProviderDemo extends CommonMethods {

    @Test 
	public void validLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys(configReader.getPropertyValue("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(configReader.getPropertyValue("password"));
		driver.findElement(By.id("btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement welcomeAttribute = driver.findElement(By.xpath("//a[@id='welcome']"));
		Assert.assertTrue(welcomeAttribute.isDisplayed());
		
		
	}
}
