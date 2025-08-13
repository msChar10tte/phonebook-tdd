package ru.netology;

import java.util.*;

public class PhoneBook {

    private final Map<String, String> contactsByName = new TreeMap<>();

    private final Map<String, String> contactsByNumber = new HashMap<>();

    public int add(String name, String number) {
        if (!contactsByName.containsKey(name)) {
            contactsByName.put(name, number);
            contactsByNumber.put(number, name);
        }
        return contactsByName.size();
    }

    public String findByNumber(String number) {
        return contactsByNumber.get(number);
    }

    public String findByName(String name) {
        return contactsByName.get(name);
    }

    public List<String> printAllNames() {
        return new ArrayList<>(contactsByName.keySet());
    }

}