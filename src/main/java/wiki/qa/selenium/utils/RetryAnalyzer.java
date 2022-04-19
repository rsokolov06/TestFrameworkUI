package wiki.qa.selenium.utils;

import java.util.logging.Logger;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	private int counter = 0;
	private int retryLimit = 3;
	private static final Logger LOGGER = Logger.getLogger(RetryAnalyzer.class.getName());
	
	public boolean retry(ITestResult result) {
		
		if(result.isSuccess() == false) {
		
			if(counter < retryLimit) {
				
				counter++;				
				LOGGER.info("RETRY ONE MORE TIME >>> " + result.getName() + " >>> " + counter);
				
				return true;
			}
		 }
		 
		return false;
	}
}
