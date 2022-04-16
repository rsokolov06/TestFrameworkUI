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

public class TC4_SortingOrderTest extends Base {

	@Test (retryAnalyzer = RetryAnalyzer.class)
	@Description("Test goal: Check that all the results are sorted by edit date.")
	@Severity(SeverityLevel.NORMAL)
	public void testSortingOrder() throws Exception {
		
		System.out.println("AdvancedSearchTest.testSortingOrder()");
	
		Base p = new HomePage(webDriver)
				.gotoAdvancedSearch()
				.enterMainSearch(Test_Data.get("mainSearch"))
				.clickAdvancedOptions()
				.selectSortingOrder(Test_Data.get("sortOrder"))
				.clickSearch();
		
		Assert.assertEquals(
				((AdvancedSearchPage)p).checkSortedInOrder(),
				true);
	}
	
}
