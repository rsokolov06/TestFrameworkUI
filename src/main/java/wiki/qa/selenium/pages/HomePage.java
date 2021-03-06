package wiki.qa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wiki.qa.selenium.base.Base;

public class HomePage extends Base {

	@FindBy(how = How.ID, using = "searchButton")
		private WebElement btnSearch;

	public HomePage(WebDriver wd) {
		webDriver = wd;
		PageFactory.initElements(wd, this);
	}
	
	public AdvancedSearchPageActions gotoAdvancedSearch() {
		
		btnSearch.click();
		
		return PageFactory.initElements(webDriver, AdvancedSearchPageActions.class);
	}

}
