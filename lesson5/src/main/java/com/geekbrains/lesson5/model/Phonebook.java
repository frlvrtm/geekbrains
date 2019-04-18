package com.geekbrains.lesson5.model;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {

    private Map<String, String> phonebook;

    public Phonebook() {
        this.phonebook = new HashMap<String, String>();
    }

    public void add(String phoneNumber, String lastName) {
        phonebook.put(phoneNumber, lastName);
    }

    public void get(String lastName) {
        if (!(phonebook.isEmpty())) {
            if (phonebook.containsValue(lastName)) {
                for (Map.Entry<String, String> o : phonebook.entrySet()) {
                    if (o.getValue().equals(lastName)) {
                        System.out.println(o.getKey());
                    }
                }
            } else {
                System.out.println("Unknown");
            }
        } else {
            System.out.println("PhoneBook is Empty!");
        }
    }

    @Override
    public String toString() {
        return phonebook.toString();
    }
}
