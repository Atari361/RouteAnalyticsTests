package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverUtils;

public class BasePage {

    protected final WebDriver webDriver;

    private BasePage() {
            webDriver = WebDriverUtils.createFirefoxDriver(); // download support later
    }

    protected BasePage(WebDriver webDriver) {
        if (webDriver != null) {
            this.webDriver = webDriver;
        } else {
            this.webDriver = WebDriverUtils.createFirefoxDriver();
        }
    }

    public static BasePage createBasePage() {
        return new BasePage();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    protected void click(By by) {
        WebElement element = getWebElement(by);
        element.click();
    }

    private WebElement getWebElement(By by) {
        return webDriver.findElement(by);
    }

    public String getText(By by) {
        WebElement element = getWebElement(by);
        return element.getText();
    }

    public void waitForPageLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(webDriver, 60);
        try {
            wait.until(result -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        } catch (Throwable error) {
            error.printStackTrace();
            assert false : ("Timeout waiting for Page Load Request to complete.");
        }
    }
}
