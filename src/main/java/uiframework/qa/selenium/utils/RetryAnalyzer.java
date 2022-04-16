package uiframework.qa.selenium.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	private int counter = 0;
	private int retryLimit = 3;
	
	public boolean retry(ITestResult result) {
		
		if(result.isSuccess() == false) {
		
			if(counter < retryLimit) {
				counter++;
				System.out.println("RETRY ONE MORE TIME >>> " + result.getName() + " >>> " + counter);
				return true;
			}
		 }
		 
		return false;
	}
}
