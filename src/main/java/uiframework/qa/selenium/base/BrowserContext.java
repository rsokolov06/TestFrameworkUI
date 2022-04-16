package uiframework.qa.selenium.base;

import java.net.MalformedURLException;

public class BrowserContext {
    private BrowserInterface strategy;

    public BrowserContext(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                this.setStrategy(new Chrome());
                break;

            case "firefox":
                this.setStrategy(new Firefox());
                break;
                
            case "edge":
                this.setStrategy(new Edge());
                break;
                
        }
    }

    private void setStrategy(BrowserInterface strategy) {
        this.strategy = strategy;
    }

    public void selectAndLaunchBrowser(Base base) throws MalformedURLException {
        this.strategy.selectAndLaunchBrowser(base);
    }
}
