package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class WebDriverUtils {

    public synchronized static WebDriver createWebDriverChrome(String fileDownloadPath) {

        //TODO implement fileDownloadPath

        String pathToChromeDriver = "resources" + File.separator + "chromedriver" + File.separator;
        String chromeDriver = (SysUtils.isMacOS()) ? "chromedriver_mac" : "chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", pathToChromeDriver + chromeDriver);
        return new ChromeDriver();
    }
}
