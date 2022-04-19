package wiki.qa.selenium.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import wiki.qa.selenium.utils.WaitUtility;

public class AdvancedSearchPageActions extends AdvancedSearchPage {

	public AdvancedSearchPageActions(WebDriver webDriver) {
		super(webDriver);
	}

	public boolean checkDidYouMeanHintPresent() {		
		return (lstDidYouMeanHint.size() > 0);
	}
	
	public AdvancedSearchPageActions clickAdvancedOptions() {
		
		WaitUtility.waitAndClick(container);
		
		return PageFactory.initElements(webDriver, AdvancedSearchPageActions.class);
	}

	public AdvancedSearchPageActions clickSearch() {
		
		btnSearch.click();
		
		return PageFactory.initElements(webDriver, AdvancedSearchPageActions.class);
	}
	
	public AdvancedSearchPageActions enterMainSearch(String searchText) {
		
		txtSearch.sendKeys(searchText);
		lblFirstHeading.click();

		return PageFactory.initElements(webDriver, AdvancedSearchPageActions.class);
	}

	public AdvancedSearchPageActions enterExactlyThisText(String searchText) {

		txtExactlyThisText.sendKeys(searchText);

		return PageFactory.initElements(webDriver, AdvancedSearchPageActions.class);
	}

	public AdvancedSearchPageActions enterNotThisText(String searchText) {

		txtNotThisText.sendKeys(searchText);

		return PageFactory.initElements(webDriver, AdvancedSearchPageActions.class);
	}

	public AdvancedSearchPageActions selectFileType(String fileType) throws Exception {
		
		ddFileType.click();
		
		if(fileType.compareToIgnoreCase("jpg") == 0) {
			liJpgFileType.click();
		} else {
			throw new Exception("File type not defined!");
		}
		
		return PageFactory.initElements(webDriver, AdvancedSearchPageActions.class);
	}
	
	public AdvancedSearchPageActions selectSortingOrder(String sortOrder) throws Exception {
		
		ddSortingOrder.click();
		
		if(sortOrder.compareToIgnoreCase("edit date") == 0) {
			liEditDate.click();
		} else {
			throw new Exception("Sort order not defined!");
		}
		
		return PageFactory.initElements(webDriver, AdvancedSearchPageActions.class);
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
