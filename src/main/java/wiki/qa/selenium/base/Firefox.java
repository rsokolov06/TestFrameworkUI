package wiki.qa.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements BrowserInterface {

    @Override
    public void selectAndLaunchBrowser(Base base) {
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();       
                
        base.webDriver = new FirefoxDriver();
    }
}
