package wiki.qa.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import wiki.qa.selenium.utils.RetryAnalyzer;
import wiki.qa.selenium.base.Base;
import wiki.qa.selenium.pages.AdvancedSearchPageActions;
import wiki.qa.selenium.pages.HomePage;

public class TC1_ExactlyThisTextHintTest extends Base {
	
	@Test (retryAnalyzer = RetryAnalyzer.class)
	@Description("Test goal: Test that hint appears when there is no corresponding page found.")
	@Severity(SeverityLevel.NORMAL)
	public void testExactlyThisTextHint() throws InterruptedException {
		
		LOGGER.info("AdvancedSearchTest.testExactlyThisText()");
		
		Base basePage = new HomePage(webDriver)
				.gotoAdvancedSearch()
				.clickAdvancedOptions()
				.enterExactlyThisText(Test_Data.get("exactlyThisText"))
				.clickSearch();
		
		Assert.assertEquals( 
				((AdvancedSearchPageActions)basePage).checkDidYouMeanHintPresent(), 
				true);
	}
}
