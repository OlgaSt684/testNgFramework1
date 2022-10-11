package class2;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class dependsOnAttributes {
	@Test
	public void login() {
		System.out.println("This is my login page");
	}
	@Test (dependsOnMethods = "login")
	public void verifyDashboardPage() {
		System.out.println("This is my ldashboard page");
	}
	@Test (dependsOnMethods = "verifyDashboardPage")
	public void logot() {
		System.out.println("This is my log out page");
	}
}
