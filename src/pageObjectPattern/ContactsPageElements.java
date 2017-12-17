package pageObjectPattern;

import org.openqa.selenium.By;

public class ContactsPageElements {

    public By getContactEmail(){
        return By.xpath("//*[@class='contacts']/*[contains(text(),'Email')]");
    }
}
