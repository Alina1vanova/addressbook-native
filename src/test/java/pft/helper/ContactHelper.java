package pft.helper;

import pft.config.Constants;
import pft.data.ContactData;

/**
 * Created by linka on 08.04.2015.
 */
public class ContactHelper extends BaseHelper implements Constants {


    public ContactHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        confirmContactCreation();
    }

    private void initContactCreation() {
        manager.getAutoItHelper()
                .winWaitAndActivate("AddressBook Portable", "", TIMEOUT)
                .click(ADD_BUTTON)
                .winWaitAndActivate("Add Contact", "", TIMEOUT);
    }

    private void fillContactForm(ContactData contact) {
        manager.getAutoItHelper().send(FIRSTNAME_FIELD, contact.getFirstName())
                .send(LASTNAME_FIELD, contact.getLastName())
                .send(STREET_FIELD, contact.getStreet())
                .send(CITY_FIELD, contact.getCity())
                .send(PHONE_FIELD, contact.getPhone())
                .send(FAX_FIELD, contact.getFax())
                .send(MOBILE_FIELD, contact.getMobile())
                .send(EMAIL_FIELD, contact.getEmail());
    }

    private void confirmContactCreation() {
        manager.getAutoItHelper().click(SAVE_BUTTON)
                .winWaitAndActivate("AddressBook Portable", "", TIMEOUT);
    }

    public ContactData getFirstContact() {
        manager.getAutoItHelper()
                .focus(LIST_VIEW)
                .send("{DOWN}{SPACE}")
                .click(EDIT_BUTTON)
                .winWaitAndActivate("Update Contact", "", TIMEOUT);

        ContactData contact = new ContactData()
                .withFirstName(manager.getAutoItHelper().getText(FIRSTNAME_FIELD))
                .withLastName(manager.getAutoItHelper().getText(LASTNAME_FIELD));

        manager.getAutoItHelper()
                .click(CANCEL_BUTTON)
                .winWaitAndActivate("AddressBook Portable", "", TIMEOUT);
        return contact;
    }

    public void deleteAll() {
        manager.getAutoItHelper().winWaitAndActivate("AddressBook Portable", "", TIMEOUT);
        try {
            Thread.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        manager.getAutoItHelper().click(SELECT_ALL_BUTTON)
                .click(DELETE_BUTTON)
                .winWaitAndActivate("Confirm", "", TIMEOUT)
                .click(YES_BUTTON);
    }

    public boolean checkEmptyList() {
        try {
            manager.getAutoItHelper()
                    .focus(LIST_VIEW)
                    .send("{DOWN}{SPACE}")
                    .click(EDIT_BUTTON)
                    .winWaitAndActivate("Information", "", TIMEOUT)
                    .click(OK_BUTTON);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
