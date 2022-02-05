package com.company;

import java.util.*;

public class PhoneBook {

    private Map<String, List<Contact>> phoneBook = new HashMap<>();


    public boolean addGroup(String groupName) {
        if (phoneBook.containsKey(groupName))
            return false;
        phoneBook.put(groupName, new ArrayList<>());
        return true;
    }


    public boolean addContact(Contact contact, String[] groupNames) {
        for (String groupName : groupNames) {
            if (!phoneBook.containsKey(groupName)) {
                System.out.println("Такой группы нет в справочнике");
                return false;
            }
            List<Contact> contactsInGroup = phoneBook.get(groupName);
            contactsInGroup.add(contact);
        }
        return true;
    }

    public void showContact(String telNumber) {
        for (Map.Entry<String, List<Contact>> allMap : phoneBook.entrySet())
            for (Contact contact : allMap.getValue())
                if (contact.getTelNumber().equals(telNumber)) {
                    System.out.println(contact);
                    return;
                }
    }


    public void showContactsInGroup(String groupName) {
        List<Contact> contactsInGroup = phoneBook.get(groupName);
        for (int i = 0; i < contactsInGroup.size(); i++) {
            Contact allContacts = contactsInGroup.get(i);
            System.out.println(allContacts);
        }
    }
}







