package com.knoldus;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PhoneBook {

    /**
     * Map that represents a directory.
     */
    private Map<String, String> directory = new HashMap<String, String>() {{
        put("Alex", "9876543210");
        put("John", "8765432109");
        put("Alice", "7654321089");
    }};

    /**
     * @return Map
     */
    public Map<String, String> getPhonebook() {
        return directory;
    }

    /**
     * @param name String
     * @return Optional
     */
    public Optional<String> findPhoneByName(final String name) {
        if (directory.containsKey(name)) {
            return Optional.of(directory.get(name));
        }
        return Optional.empty();

    }

    /**
     * @param number
     * @return Optional arguments
     */
    public Optional findPhoneByNumber(final String number) {
        for (Map.Entry contact : directory.entrySet()
        ) {
            if (contact.getValue().equals(number)) {
                return Optional.of(contact.getKey());
            }

        }

        return Optional.empty();
    }

    /**
     * @return String argument
     */
    public String toString() {
        System.out.println("Hello");
        return "Phonebook" + directory;

    }

}
