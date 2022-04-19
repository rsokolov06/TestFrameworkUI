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

public class TC3_FileTypeSearchTest extends Base {

	@Test (retryAnalyzer = RetryAnalyzer.class)
	@Description("Test goal: Check that all the results corresponds to the searching file type.")
	@Severity(SeverityLevel.NORMAL)
	public void testFileTypeSearch() throws Exception {
		
		LOGGER.info("AdvancedSearchTest.testFileTypeSearch()");
		
		Base basePage = new HomePage(webDriver)
				.gotoAdvancedSearch()
				.enterMainSearch(Test_Data.get("mainSearch"))
				.clickAdvancedOptions()
				.selectFileType(Test_Data.get("selectFileType"))
				.clickSearch();
	
		Assert.assertEquals(
				((AdvancedSearchPageActions)basePage)
				.checkResultsHaveType(Test_Data.get("selectFileType")),
				true);
	}
}
