package wiki.qa.selenium.utils;

import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;
import wiki.qa.selenium.base.Base;

public class AllureTestListener implements ITestListener {
	
	private static final Logger LOGGER = Logger.getLogger(AllureTestListener.class.getName());

	private String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getMethodName();
	}
	
	@Attachment(value = "Page screenshot with discrepancy.", type = "image/png")
	public byte[] saveScreenshotPNG(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public void onTestSuccess(ITestResult iTestResult) {
		LOGGER.info("SUCCEED " + getTestMethodName(iTestResult));
	}
	
	public void onTestFailure(ITestResult iTestResult) {
		
		LOGGER.info("FAILED " + getTestMethodName(iTestResult));
		
		WebDriver driver = ((Base)iTestResult.getInstance()).getDriver();		
		
		if (driver instanceof WebDriver) {
			LOGGER.info("Screenshot captured for test case:" + getTestMethodName(iTestResult));
			saveScreenshotPNG(driver);
		}
	}
	
}
