package com.knoldus;

public class Main {
    /**
     * @param args String[] , main method
     */
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(phoneBook);

        System.out.println(phoneBookCrawler.findPhoneByNameAndPunishIfNothingFoundUsingstreams("Alex"));
        try {
            System.out.println(phoneBookCrawler.findPhoneByNameAndPunishIfNothingFoundUsingstreams("Ron"));
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFound("Alice"));
        System.out.println(phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFound("Sam"));

        System.out.println(phoneBookCrawler.findPhoneByNameandPrintPhoneBookusingPhoneBooktoStringMethod("John"));
        System.out.println(phoneBookCrawler.findPhoneByNameandPrintPhoneBookusingPhoneBooktoStringMethod("Amber"));


        System.out.println(phoneBookCrawler.findPhoneByNameAndPunishIfNothingFoundUsingstreams("John"));
        try {
            System.out.println(phoneBookCrawler.findPhoneByNameAndPunishIfNothingFoundUsingstreams("Max"));
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(phoneBookCrawler.findPhoneByNameAndPrintPhonebookIfNothingFoundUsingstreams("Alex"));
        System.out.println(phoneBookCrawler.findPhoneByNameAndPrintPhonebookIfNothingFoundUsingstreams("James"));

        System.out.println(phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Alex", "8952"));
        System.out.println(phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Joe", "9876543210"));
        System.out.println(phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("James", "8952"));


    }
}
