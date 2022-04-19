package wiki.qa.selenium.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wiki.qa.selenium.base.Base;

public class AdvancedSearchPage extends Base {

	// Main line
	
	@FindBy(how = How.ID, using = "firstHeading")
	protected WebElement lblFirstHeading;
	
	@FindBy(how = How.NAME, using = "search")
	protected WebElement txtSearch;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Search']")
	protected WebElement btnSearch;

	
	// Advanced Search criteria
	
	@FindBy(how = How.XPATH, using = "(//div[@class='mw-advancedSearch-container']//div)[1]")
	protected WebElement container;
	
	@FindBy(how = How.XPATH, using = "//*[@id='advancedSearchField-phrase']//input")
	protected WebElement txtExactlyThisText;

	@FindBy(how = How.XPATH, using = "//*[@id='advancedSearchField-not']//input")
	protected WebElement txtNotThisText;

	@FindBy(how = How.XPATH, using = "//*[@id='advancedSearchField-filetype']")
	protected WebElement ddFileType;
	
	@FindBy(how = How.XPATH, using = "//span[text()='jpg']")
	protected WebElement liJpgFileType;

	@FindBy(how = How.XPATH, using = "//*[@id='advancedSearchField-sort']")
	protected WebElement ddSortingOrder;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Edit date')]")
	protected WebElement liEditDate;
	
	
	// Search results
	
	@FindBy(how = How.XPATH, using = "//div[@class='searchdidyoumean']")
	protected List<WebElement> lstDidYouMeanHint;
	
	@FindBy(how = How.XPATH, using = "//div[@class='mw-search-result-heading']")
	protected List<WebElement> lstSearchResultsHeadings;
	
	@FindBy(how = How.XPATH, using = "//div[@class='searchresult']")
	protected List<WebElement> lstSearchResultsText;
	
	@FindBy(how = How.CLASS_NAME, using = "mw-search-result")
	protected List<WebElement> lstSearchResults;
	
	@FindBy(how = How.CLASS_NAME, using = "mw-search-result-data")
	protected List<WebElement> lstSearchResultsData;

	public AdvancedSearchPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
}
