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

public class TC3_FileTypeSearchTest extends Base {

	@Test (retryAnalyzer = RetryAnalyzer.class)
	@Description("Test goal: Check that all the results corresponds to the searching file type.")
	@Severity(SeverityLevel.NORMAL)
	public void testFileTypeSearch() throws Exception {
		
		System.out.println("AdvancedSearchTest.testFileTypeSearch()");
		
		Base p = new HomePage(webDriver)
				.gotoAdvancedSearch()
				.enterMainSearch(Test_Data.get("mainSearch"))
				.clickAdvancedOptions()
				.selectFileType(Test_Data.get("selectFileType"))
				.clickSearch();
	
		Assert.assertEquals(
				((AdvancedSearchPage)p).checkResultsHaveType(Test_Data.get("selectFileType")),
				true);
	}
	
}
