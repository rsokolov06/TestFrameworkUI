package uiframework.qa.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import uiframework.qa.selenium.base.Base;
import uiframework.qa.selenium.pages.AdvancedSearchPage;
import uiframework.qa.selenium.pages.HomePage;
import uiframework.qa.selenium.utils.RetryAnalyzer;

public class TC2_NotThisTextTest extends Base {

	@Test (retryAnalyzer = RetryAnalyzer.class)
	@Description("Test goal: Test that all result do not contain the following text.")
	@Severity(SeverityLevel.NORMAL)
	public void testNotThisText() throws InterruptedException {
		
		System.out.println("AdvancedSearchTest.testNotThisText()");
		
		Base p = new HomePage(webDriver)
				.gotoAdvancedSearch()
				.clickAdvancedOptions()
				.enterMainSearch(Test_Data.get("mainSearch"))
				.enterNotThisText(Test_Data.get("notThisText"))
				.clickSearch();
		
		Assert.assertEquals(
				((AdvancedSearchPage)p).checkResultsContainNo(Test_Data.get("mainSearch")),
				true);
	}
	
}
