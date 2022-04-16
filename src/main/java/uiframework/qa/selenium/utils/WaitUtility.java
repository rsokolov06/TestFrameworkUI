package uiframework.qa.selenium.utils;

import org.openqa.selenium.WebElement;

public class WaitUtility {

	public static void waitAndClick(WebElement element) {
		while(true) {

			try {

				element.click();				
				break;

			} catch(Exception ex) {

			}
		}
	}
}
