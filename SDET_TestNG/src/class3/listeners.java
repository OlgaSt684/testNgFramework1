package class3;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Starting test with the name: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed and we a capturing that the final screenshot");
	}

	public void onTestFailureButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Result");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped test case is: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Failed test case is: " + result.getName());
	}

	public void onStart(ITestResult context) {
	}

	public void onFinish(ITestResult context) {
	}


}
