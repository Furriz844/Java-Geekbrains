package ru.vdmitriy.hm2;

/**
 * Created by VasilyevD on 30.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        /**
         * Add some records
         */
        phoneBook.addRecord(new PhoneRecord("Maria Petrova", "+7-925-243-11-11", "maria@petrova.ru"));
        phoneBook.addRecord(new PhoneRecord("Sasha Sidorov", "+7-903-243-23-11", "sasha@sidorov.org"));
        phoneBook.addRecord(new PhoneRecord("Vanya Sidorov", "+7-962-123-22-56", "vanya@fockin.com"));

        System.out.println(phoneBook.getPhoneByName("Sidorov"));
    }
}
