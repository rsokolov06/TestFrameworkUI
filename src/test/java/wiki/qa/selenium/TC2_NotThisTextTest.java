package wiki.qa.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import wiki.qa.selenium.base.Base;
import wiki.qa.selenium.pages.AdvancedSearchPageActions;
import wiki.qa.selenium.pages.HomePage;
import wiki.qa.selenium.utils.RetryAnalyzer;

public class TC2_NotThisTextTest extends Base {

	@Test (retryAnalyzer = RetryAnalyzer.class)
	@Description("Test goal: Test that all result do not contain the following text.")
	@Severity(SeverityLevel.NORMAL)
	public void testNotThisText() throws InterruptedException {
		
		LOGGER.info("AdvancedSearchTest.testNotThisText()");
		
		Base basePage = new HomePage(webDriver)
				.gotoAdvancedSearch()
				.clickAdvancedOptions()
				.enterMainSearch(Test_Data.get("mainSearch"))
				.enterNotThisText(Test_Data.get("notThisText"))
				.clickSearch();
		
		Assert.assertEquals(
				((AdvancedSearchPageActions)basePage)
				.checkResultsContainNo(Test_Data.get("mainSearch")),
				true);
	}
}
