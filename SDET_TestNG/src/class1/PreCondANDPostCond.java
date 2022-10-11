package class1;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PreCondANDPostCond {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("I am before class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("I am after class");}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am beforeMethod and I will execute before every test ");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am afterMethod and I will execute after every test ");
	}

	@Test
	public void firstMethod() {
		System.out.println("This is my first method");
	}
	
	@Test
	public void secondMethod() {
		Assert.assertTrue(false);
		System.out.println("This is my second method");
	}
	@Test
	public void thirdMethod() {
		System.out.println("This is my third method");
	}

}
