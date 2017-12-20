package mainTests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pageObjectPattern.ContactsPage;
import pageObjectPattern.HomePage;
import testExecutors.RouteAnalyticsTestExecutor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FirstTest extends RouteAnalyticsTestExecutor {

    @AfterClass
    public void after(){

        File file = ((FirefoxDriver) webDriver).getScreenshotAs(OutputType.FILE);
        File screenshotsDir = new File("resources/screenshots/");
        if (!screenshotsDir.exists()) screenshotsDir.mkdir();
        File destination = new File(screenshotsDir.getPath() + "/" + this.getClass().getSimpleName() + ".png");
        try {
            Files.move(file.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        webDriver = openDriverIfNotExists();
        HomePage homePage = goToHomePage();
        ContactsPage contactsPage = homePage.clickOnContactsTab();
        String contactEmail = contactsPage.getContactEmail();
        assertTrue(
                contactEmail.contains("melnyk.andreew@gmail.com"), "Unexpected email on Contacts page!");
    }



}
