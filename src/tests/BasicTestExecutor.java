package tests;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import pageObjectPattern.BasePage;

public class BasicTestExecutor extends Assert {

    private BasePage basePage;
    protected WebDriver webDriver;

    @AfterClass(alwaysRun = true)
    public void haltSessions() {
        closeBrowserSession();
    }

    protected WebDriver openDriverIfNotExists() {
        if (checkWebDriver(basePage) == null) {
            basePage = BasePage.createBasePage();
        }
        return basePage.getWebDriver();
    }

    private WebDriver checkWebDriver(BasePage basePage) {
        try {
            if (basePage == null) {
                return null;
            }
            if (basePage.getWebDriver() == null) {
                return null;
            }
            basePage.getWebDriver().getTitle();
            return webDriver;
        } catch (WebDriverException e) {
            return null;
        }
    }

    private void closeBrowserSession() {
        if (webDriver != null) {
            if (((RemoteWebDriver) webDriver).getSessionId() != null) {
                try {
                    webDriver.close();
                } catch (NoSuchSessionException nsse) {
                    System.out.println("Can't close createBasePage driver due to: " + nsse.getMessage());
                }
            }
            webDriver.quit();
        }
    }
}
