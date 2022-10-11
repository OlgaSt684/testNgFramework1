package class2;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertion1 {
	

	@Test (groups="smoke")
	public void SoftAssertionValidation() {
		String expected = "I live in NY";
		String actual = "I live in LA";

		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(expected, actual);
		System.out.println("My code after first assertion");

		AssertJUnit.assertTrue(false);
		System.out.println("My code after second assertion");

		AssertJUnit.assertFalse(true);
		System.out.println("My code after third assertion");

		AssertJUnit.assertFalse(false);
		System.out.println("My code after fourth assertion");

		String newExpected = "This is last assertion";
		String newActual = "This is last assertion";
		AssertJUnit.assertEquals(newExpected, newActual);
		
		// to collect all the assertion information
		// should be the last statement of your test
		softAssert.assertAll(); //assertAll method
		}
		
		@Test (groups="smoke")
		public void anotherMethod() {
			System.out.println("Test method");
		}
		
	

}
