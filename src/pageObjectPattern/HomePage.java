package pageObjectPattern;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private HomePageElements homePageElements;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        homePageElements = new HomePageElements();
    }

    public ContactsPage clickOnContactsTab(){
        click(homePageElements.getContactsTab());
        waitForPageLoaded();
        return new ContactsPage(webDriver);
    }
}
