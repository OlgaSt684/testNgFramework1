package class2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class grouping {
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am beforeMethod and I will execute before every test ");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am afterMethod and I will execute after every test ");
	}

	@Test (groups= {"Smoke"})
	public void firstMethod() {
		System.out.println("This is my first method");
	}
	
	@Test (groups= {"Smoke"})
	public void secondMethod() {
		System.out.println("This is my second method");
	}
	@Test (groups= {"Regression"})
	public void thirdMethod() {
		System.out.println("This is my third method");
	}

}
