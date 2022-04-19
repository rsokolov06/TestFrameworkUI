package wiki.qa.selenium.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import wiki.qa.selenium.utils.TestDataUtility;

import org.testng.annotations.AfterMethod;
import java.io.IOException;
import java.util.logging.Logger;

public class Base {

    protected WebDriver webDriver;    
    protected final String URL = "https://en.wikipedia.org/";    
    public static TestDataUtility Test_Data;
    protected static final Logger LOGGER = Logger.getLogger(Base.class.getName());
    
    @BeforeSuite
    public void initSuite() throws IOException {
    	Test_Data = new TestDataUtility();
     	Test_Data.fetch();
    }
    
    @BeforeMethod
    public void init() throws IOException {
    	    	
    	BrowserContext browserContext = new BrowserContext(getBrowser());
        browserContext.selectAndLaunchBrowser(this);
        
        webDriver.manage().window().maximize();
        webDriver.get(URL);
    }
    
    public String getUrl() {
    	return webDriver.getCurrentUrl();
    }
    
    private String getBrowser() {
        String browser = System.getProperties().getProperty("browser");
        
        LOGGER.info("BROWSER: " + browser);

        if (browser == null) {
        	LOGGER.info("No browser -Dbrowser option is set, by default using chrome");
            return "chrome";
        }

        return browser;
    }
    
    public WebDriver getDriver() {		
		return webDriver;
	}
    
    @AfterMethod
    public void teardown() {
    	LOGGER.info("AfterClass method...");		
		
		if(webDriver != null) {
			webDriver.quit();
		}
		webDriver = null;	
    }
}