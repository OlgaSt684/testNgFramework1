package class1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class priority {

	@Test(priority = 3)
	public void loginMethod() {
		System.out.println("I am login method");
	}

	@Test(priority = 1)
	public void launchBrowserMethod() {
		System.out.println("I am launch browser method");
	}

	@Test (priority = 2)
	public void navigateUrlMethod() {
		System.out.println("I am navigate URL method");
	}

	@Test (priority = 4)
	public void closeBrowserMethod() {
		System.out.println("I am close Browser method");
	}
}
