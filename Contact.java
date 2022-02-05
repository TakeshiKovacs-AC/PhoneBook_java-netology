package com.company;

import java.util.*;

public class Contact {
    private String name;
    private final String telNumber;

    public Contact(String name, String telNumber) {
        this.name = name;
        this.telNumber = telNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    @Override
    public String toString() {
        return "Имя: " + name + "; номер телефона: " + telNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !obj.getClass().equals(Contact.class)) return false;

        Contact compContact = (Contact) obj;
        return this.telNumber.equals(compContact.telNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telNumber);
    }
}