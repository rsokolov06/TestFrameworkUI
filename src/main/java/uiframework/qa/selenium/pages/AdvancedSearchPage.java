package uiframework.qa.selenium.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import uiframework.qa.selenium.base.Base;
import uiframework.qa.selenium.utils.WaitUtility;

public class AdvancedSearchPage extends Base {

	// Main line
	
	@FindBy(how = How.ID, using = "firstHeading")
	private WebElement lblFirstHeading;
	
	@FindBy(how = How.NAME, using = "search")
	private WebElement txtSearch;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Search']")
	private WebElement btnSearch;

	
	// Advanced Search criteria
	
	@FindBy(how = How.XPATH, using = "(//div[@class='mw-advancedSearch-container']//div)[1]")
	private WebElement container;
	
	@FindBy(how = How.XPATH, using = "//*[@id='advancedSearchField-phrase']//input")
	private WebElement txtExactlyThisText;

	@FindBy(how = How.XPATH, using = "//*[@id='advancedSearchField-not']//input")
	private WebElement txtNotThisText;

	@FindBy(how = How.XPATH, using = "//*[@id='advancedSearchField-filetype']")
	private WebElement ddFileType;
	
	@FindBy(how = How.XPATH, using = "//span[text()='jpg']")
	private WebElement liJpgFileType;

	@FindBy(how = How.XPATH, using = "//*[@id='advancedSearchField-sort']")
	private WebElement ddSortingOrder;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Edit date')]")
	private WebElement liEditDate;
	
	
	// Search results
	
	@FindBy(how = How.XPATH, using = "//div[@class='searchdidyoumean']")
	private List<WebElement> lstDidYouMeanHint;
	
	@FindBy(how = How.XPATH, using = "//div[@class='mw-search-result-heading']")
	private List<WebElement> lstSearchResultsHeadings;
	
	@FindBy(how = How.XPATH, using = "//div[@class='searchresult']")
	private List<WebElement> lstSearchResultsText;
	
	@FindBy(how = How.CLASS_NAME, using = "mw-search-result")
	private List<WebElement> lstSearchResults;
	
	@FindBy(how = How.CLASS_NAME, using = "mw-search-result-data")
	private List<WebElement> lstSearchResultsData;


	public AdvancedSearchPage(WebDriver wd) {
		webDriver = wd;
		PageFactory.initElements(wd, this);
	}
	
	public boolean checkDidYouMeanHintPresent() {		
		return (lstDidYouMeanHint.size() > 0);
	}
	
	public AdvancedSearchPage clickAdvancedOptions() {
		
		WaitUtility.waitAndClick(container);
		
		return PageFactory.initElements(webDriver, AdvancedSearchPage.class);
	}

	public AdvancedSearchPage clickSearch() {
		
		btnSearch.click();
		
		return PageFactory.initElements(webDriver, AdvancedSearchPage.class);
	}
	
	public AdvancedSearchPage enterMainSearch(String searchText) {
		
		txtSearch.sendKeys(searchText);
		lblFirstHeading.click();

		return PageFactory.initElements(webDriver, AdvancedSearchPage.class);
	}

	public AdvancedSearchPage enterExactlyThisText(String searchText) {

		txtExactlyThisText.sendKeys(searchText);

		return PageFactory.initElements(webDriver, AdvancedSearchPage.class);
	}

	public AdvancedSearchPage enterNotThisText(String searchText) {

		txtNotThisText.sendKeys(searchText);

		return PageFactory.initElements(webDriver, AdvancedSearchPage.class);
	}

	public AdvancedSearchPage selectFileType(String fileType) throws Exception {
		
		ddFileType.click();
		
		if(fileType.compareToIgnoreCase("jpg") == 0) {
			liJpgFileType.click();
		} else {
			throw new Exception("File type not defined!");
		}
		
		return PageFactory.initElements(webDriver, AdvancedSearchPage.class);
	}
	
	public AdvancedSearchPage selectSortingOrder(String sortOrder) throws Exception {
		
		ddSortingOrder.click();
		
		if(sortOrder.compareToIgnoreCase("edit date") == 0) {
			liEditDate.click();
		} else {
			throw new Exception("Sort order not defined!");
		}
		
		return PageFactory.initElements(webDriver, AdvancedSearchPage.class);
	}
	
	public boolean checkResultsContainNo(String strNotThisText) {
		
		for (int i = 0; i < lstSearchResultsHeadings.size(); i++ ) {
			
			if(lstSearchResultsHeadings.get(i).getText().contains(strNotThisText) == true) {
				return false;
			}
		}
		
		for (int i = 0; i < lstSearchResultsText.size(); i++ ) {
			
			if(lstSearchResultsText.get(i).getText().contains(strNotThisText) == true) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean checkResultsHaveType(String fileType) {
	
		// Check for images in the list of results
		for(int i = 0; i < lstSearchResults.size(); i++ ) {			
			
			List<WebElement> lst = lstSearchResults.get(i).findElements(By.tagName("a"));
			
			String aHref = lst.get(0).getAttribute("href");
			String type = aHref.substring(aHref.length() - 3, aHref.length());
			
			if ( type.compareToIgnoreCase(fileType) != 0 ) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean checkSortedInOrder() throws ParseException {
		
		for (int i = 1; i < lstSearchResultsData.size(); i++ ) {
			
			Date date1 = convertToDate(lstSearchResultsData.get(i - 1).getText());
			Date date2 = convertToDate(lstSearchResultsData.get(i).getText());
			
			if (date1.compareTo(date2) < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	private Date convertToDate(String result) throws ParseException {
		
		String[] text = result.split(" ");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
		
		String date = text[text.length - 3] + "-" 
					+ text[text.length - 2].substring(0, 3).toUpperCase() + "-" +
						text[text.length - 1] + " "
						+ text[text.length - 4].substring(0, text[text.length - 4].length()-1);
				
		return formatter.parse(date);
	}
}
