package uiframework.qa.selenium.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;
import uiframework.qa.selenium.base.Base;

public class AllureTestListener implements ITestListener {

	private String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getMethodName();
	}
	
	@Attachment(value = "Page screenshot with discrepancy.", type = "image/png")
	public byte[] saveScreenshotPNG(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("SUCCEED " + getTestMethodName(iTestResult));
	}
	
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("FAILED " + getTestMethodName(iTestResult));
		WebDriver driver = ((Base)iTestResult.getInstance()).getDriver();		
		if (driver instanceof WebDriver) {
			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
			saveScreenshotPNG(driver);
		}
	}
	
}
