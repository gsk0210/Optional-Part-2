package com.knoldus;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;


public class PhoneBookCrawler {

    /**
     * Phonebook object.
     */
    private PhoneBook phoneBook;

    /**
     * @param phoneBook Phonebook object
     */
    public PhoneBookCrawler(final PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    /**
     * @param name String argument
     * @return number String
     */
    public String findPhoneByNameAndPunishIfNothingFound(final String name) {
        return phoneBook.findPhoneByName(name).
                orElseThrow(() -> new NullPointerException("Contact is not in "
                        + "the directory"));
    }

    /**
     * @param name String
     * @return Map argument
     */
    public String findPhoneByNameAndPrintPhoneBookIfNothingFound(final String name) {
        return phoneBook.findPhoneByName(name).
                orElse("Phonebook" + phoneBook.getPhonebook());
    }

    /**
     * @param name
     * @return String argument
     */
    public String findPhoneByNameandPrintPhoneBookusingPhoneBooktoStringMethod(final String name) {
        return phoneBook.findPhoneByName(name).orElse(phoneBook.toString());
    }

    /**
     * @param name String
     * @return Optional<String> arguments
     */
    public Optional<String> findPhoneByNameAndPunishIfNothingFoundUsingstreams(final String name) {
        if (phoneBook.getPhonebook().containsKey(name)) {
            return phoneBook.getPhonebook().entrySet().
                    stream().filter(p -> name.equals(p.getKey())).
                    map(Map.Entry::getValue).findFirst();
        } else {
            throw new NoSuchElementException("Provide Data");
        }
    }

    /**
     * @param name String
     * @return String argument
     */
    public String findPhoneByNameAndPrintPhonebookIfNothingFoundUsingstreams(final String name) {
        if (phoneBook.getPhonebook().containsKey(name)) {
            return phoneBook.getPhonebook().entrySet().
                    stream().filter(p -> name.equals(p.getKey())).
                    map(Map.Entry::getValue).findFirst().get();
        }
        return phoneBook.getPhonebook().toString();
    }

    /**
     * @param name
     * @param number
     * @return String
     */
    public String findPhoneNumberByNameOrNameByPhoneNumber(final String name, final String number) {
        if (phoneBook.findPhoneByName(name).isPresent()) {
            return phoneBook.findPhoneByName(name).get();
        } else if (phoneBook.findPhoneByNumber(number).isPresent()) {
            return phoneBook.findPhoneByNumber(number).toString();
        } else {
            return "Contact is not present";
        }
    }
}


