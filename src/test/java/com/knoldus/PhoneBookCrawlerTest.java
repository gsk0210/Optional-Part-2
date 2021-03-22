package com.knoldus;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.opentest4j.MultipleFailuresError;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookCrawlerTest {

    PhoneBook phoneBook=new PhoneBook();
    PhoneBookCrawler phoneBookCrawler=new PhoneBookCrawler(phoneBook);

    @org.junit.jupiter.api.Test
    void findPhoneByNameAndPunishIfNothingFound() {
        assertAll("Return number if contact exist, else throw Null Pointer Exception  ",
                ()->assertEquals("9876543210",phoneBookCrawler.findPhoneByNameAndPunishIfNothingFound("Alex")),
                ()->assertThrows(NullPointerException.class,()->phoneBookCrawler.findPhoneByNameAndPunishIfNothingFound("Ron"))
        );
    }

    @org.junit.jupiter.api.Test
    void findPhoneByNameAndPrintPhoneBookIfNothingFound() {
        assertAll("Return number if contact exist else return the directory",
                ()->assertEquals("8765432109",phoneBookCrawler.findPhoneByNameAndPunishIfNothingFound("John")),
                ()->assertEquals("Phonebook{Alex=9876543210, Alice=7654321089, John=8765432109}",phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFound("Sean"))
                );
    }

    @org.junit.jupiter.api.Test
    void findPhoneByNameandPrintPhoneBookusingPhoneBooktoStringMethod() {
        assertAll("Implementation of findPhoneByNameAndPrintPhoneBookIfNothingFound  using toString",
                ()->assertEquals("7654321089",phoneBookCrawler.findPhoneByNameandPrintPhoneBookusingPhoneBooktoStringMethod("Alice")),
                ()->assertEquals("Phonebook{Alex=9876543210, Alice=7654321089, John=8765432109}",phoneBookCrawler.findPhoneByNameandPrintPhoneBookusingPhoneBooktoStringMethod("Sean"))
                );
    }

    @org.junit.jupiter.api.Test
    void findPhoneByNameAndPunishIfNothingFoundUsingstreams() {
        assertAll("Implement findPhoneByNameAndPunishIfNothingFound using streams",
                ()->assertEquals("9876543210",phoneBookCrawler.findPhoneByNameAndPrintPhonebookIfNothingFoundUsingstreams("Alex")),
                ()->assertThrows(NoSuchElementException.class,()->phoneBookCrawler.findPhoneByNameAndPunishIfNothingFoundUsingstreams("Bruce")));
    }

    @org.junit.jupiter.api.Test
    void findPhoneByNameAndPrintPhonebookIfNothingFoundUsingstreams() {
        assertAll("Implement findPhoneByNameAndPrintPhonebookIfNothingFoundUsingstreams using streams",
                ()->assertEquals("8765432109",phoneBookCrawler.findPhoneByNameAndPrintPhonebookIfNothingFoundUsingstreams("John")),
                ()->assertEquals("{Alex=9876543210, Alice=7654321089, John=8765432109}",phoneBookCrawler.findPhoneByNameAndPrintPhonebookIfNothingFoundUsingstreams("Candice"))
                );
    }


    @Test
    void findPhoneNumberByNameOrNameByPhoneNumber() {
        assertAll("Return number if name exist else return name if number exist",
                ()->assertEquals("8765432109",phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("John","8796")),
                ()->assertEquals("Optional[Alex]",phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("abc","9876543210")),
                ()->assertEquals("Contact is not present",phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Richie","6543210987"))
        );
    }
}