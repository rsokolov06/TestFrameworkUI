package uiframework.qa.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import uiframework.qa.selenium.utils.RetryAnalyzer;
import uiframework.qa.selenium.base.Base;
import uiframework.qa.selenium.pages.AdvancedSearchPage;
import uiframework.qa.selenium.pages.HomePage;

public class TC1_ExactlyThisTextHintTest extends Base {
	
	
	@Test (retryAnalyzer = RetryAnalyzer.class)
	@Description("Test goal: Test that hint appears when there is no corresponding page found.")
	@Severity(SeverityLevel.NORMAL)
	public void testExactlyThisTextHint() throws InterruptedException {
		
		System.out.println("AdvancedSearchTest.testExactlyThisText()");
		
		Base p = new HomePage(webDriver)
				.gotoAdvancedSearch()
				.clickAdvancedOptions()
				.enterExactlyThisText(Test_Data.get("exactlyThisText"))
				.clickSearch();
		
		Assert.assertEquals( 
				((AdvancedSearchPage)p).checkDidYouMeanHintPresent(), 
				true);
	}
	
}
