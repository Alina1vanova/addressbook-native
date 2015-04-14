package pft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.data.ContactData;
import pft.data.ContactTestData;

public class TestContact extends TestBase {

    @Test(dataProvider = "randomValidContact", dataProviderClass = ContactTestData.class, dependsOnMethods = { "deleteAllContacts" })
    public void createContactWithValidData(ContactData contact) {
        app.getContactHelper().createContact(contact);
        ContactData createdContact = app.getContactHelper().getFirstContact();
        Assert.assertEquals(contact, createdContact);
    }

    @Test
    public void deleteAllContacts(){
        app.getContactHelper().deleteAll();
        Assert.assertTrue(app.getContactHelper().checkEmptyList(),"List of contacts is not empty after deletion all contacts");
    }
}
