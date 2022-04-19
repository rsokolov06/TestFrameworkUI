package wiki.qa.selenium.base;

import java.net.MalformedURLException;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edge implements BrowserInterface {

	@Override
	public void selectAndLaunchBrowser(Base base) throws MalformedURLException {
		WebDriverManager.edgedriver().setup();
		base.webDriver = new EdgeDriver();
	}

}
