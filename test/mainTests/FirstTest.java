package mainTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pageObjectPattern.ContactsPage;
import pageObjectPattern.HomePage;
import tests.RouteAnalyticsTestExecutor;

public class FirstTest extends RouteAnalyticsTestExecutor {

    @AfterClass
    public void after(){
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
