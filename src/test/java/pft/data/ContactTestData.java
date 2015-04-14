package pft.data;

import org.testng.annotations.DataProvider;

import java.text.ParseException;
import java.util.*;

public class ContactTestData {

    @DataProvider(name = "randomValidContact")
    private static Iterator<Object[]> randomValidContactData() throws ParseException {
        List<Object[]> list = new ArrayList<Object[]>();
        ContactData contact = generateContact();
        list.add(new Object[]{contact});
        return list.iterator();
    }

    private static ContactData generateContact() {
        return new ContactData()
                .withFirstName(generateRandomString())
                .withLastName(generateRandomString())
                .withStreet(generateRandomString() + " " + generateRandomNumber(1000))
                .withCity(generateRandomString())
                .withPhone(generateRandomNumber(Integer.MAX_VALUE))
                .withFax(generateRandomNumber(Integer.MAX_VALUE))
                .withMobile(generateRandomNumber(Integer.MAX_VALUE))
                .withFax(generateRandomNumber(Integer.MAX_VALUE))
                .withEmail(generateRandomString());
    }

    private static String generateRandomString() {
        Random rnd = new Random();
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer randomString = new StringBuffer();
        int length = rnd.nextInt(20);
        for (int i = 1; i < length; i++) {
            double index = Math.random() * letters.length();
            randomString.append(letters.charAt((int) index));
        }
        return randomString.toString();
    }


    private static String generateRandomNumber(int boundary) {
        Random rnd = new Random();
        return Integer.toString(rnd.nextInt(boundary) + 1);

    }

}
