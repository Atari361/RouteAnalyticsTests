package pageObjectPattern;

import org.openqa.selenium.By;

public class HomePageElements {

    public By getContactsTab(){
        return By.linkText("Contacts");
    }
}
