package lesson4;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    private Map<String, String> phoneBook = new TreeMap<>();

    public void add(String nameContact, String phoneNumber) {
        if (phoneBook.containsKey(nameContact)) {
            for (Map.Entry<String, String> elem : phoneBook.entrySet()) {
                elem.setValue(elem.getValue() + ", " + phoneNumber);
            }
        } else {
            phoneBook.put(nameContact, phoneNumber);
        }
    }

    public void get(String nameContact) {
        System.out.println(phoneBook.get(nameContact));
    }

    public void showPhoneBook() {
        for (Map.Entry<String, String> elemPB : phoneBook.entrySet()) {
            System.out.println(elemPB.getKey() + " - " + elemPB.getValue());
        }
    }

    public static class Test {
        public static void main(String[] args) {

            PhoneBook phoneBook = new PhoneBook();

            phoneBook.add("Fedor", "89289004047");
            phoneBook.add("Fedor", "89289004048");
            phoneBook.add("Sidr", "89289004049");

            phoneBook.get("Fedor");
            phoneBook.showPhoneBook();

        }
    }

}
