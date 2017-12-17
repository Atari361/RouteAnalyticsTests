package pageObjectPattern;

import org.openqa.selenium.WebDriver;

public class ContactsPage extends BasePage{

    ContactsPageElements contactsPageElements;

    protected ContactsPage(WebDriver webDriver) {
        super(webDriver);
        contactsPageElements = new ContactsPageElements();
    }


    public String getContactEmail() {
        return getText(contactsPageElements.getContactEmail());
    }
}
