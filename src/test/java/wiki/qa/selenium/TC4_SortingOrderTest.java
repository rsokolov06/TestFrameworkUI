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

public class TC4_SortingOrderTest extends Base {

	@Test (retryAnalyzer = RetryAnalyzer.class)
	@Description("Test goal: Check that all the results are sorted by edit date.")
	@Severity(SeverityLevel.NORMAL)
	public void testSortingOrder() throws Exception {
		
		LOGGER.info("AdvancedSearchTest.testSortingOrder()");
	
		Base page = new HomePage(webDriver)
				.gotoAdvancedSearch()
				.enterMainSearch(Test_Data.get("mainSearch"))
				.clickAdvancedOptions()
				.selectSortingOrder(Test_Data.get("sortOrder"))
				.clickSearch();
		
		Assert.assertEquals(
				((AdvancedSearchPageActions)page).checkSortedInOrder(),
				true);
	}
}
