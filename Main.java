package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        PhoneBook contacts = new PhoneBook();

        Scanner scan = new Scanner(System.in);

        fillPhoneBookByGroups(contacts, scan);
        fillPhoneBookByContacts(contacts, scan);
        System.out.println();
        findByGroup(contacts, scan);
        System.out.println();
        findByTelNumber(contacts, scan);
    }


    private static void fillPhoneBookByContacts(PhoneBook contacts, Scanner scan) {
        while (true) {
            System.out.println("Добавить контакт в формате \"имя\" [пробел] \"номер телефона\"");
            System.out.println("По окончании ввода введите \"finish\"");
            String input = scan.nextLine();
            if (input.equals("finish")) {
                break;
            }


            String[] contactInput = input.split(" ");

            Contact contact = new Contact(contactInput[0], contactInput[1]);

            System.out.println("Добавить контакт в группу...");
            String[] groupNames = scan.nextLine().split(" ");

            contacts.addContact(contact, groupNames);


        }
    }

    private static void fillPhoneBookByGroups(PhoneBook contacts, Scanner scan) {
        while (true) {
            System.out.println("Добавить группы");
            System.out.println("По окончании ввода введите \"finish\"");
            String input = scan.nextLine();
            if (input.equals("finish")) {
                break;
            }
            contacts.addGroup(input);
        }
    }

    private static void findByGroup(PhoneBook contacts, Scanner scan) {
        while (true) {
            System.out.println("Введите группу поиска");
            System.out.println("По окончании ввода введите \"finish\"");
            try {
                String input = scan.nextLine();

                if (input.equals("finish")) {
                    break;
                }
                System.out.println("В группе " + input + " находятся следующие контакты: ");
                contacts.showContactsInGroup(input);
            } catch (NullPointerException exc) {
                System.out.println("Данной группы нет в телефонной книге");
            }
        }
    }

    private static void findByTelNumber(PhoneBook contacts, Scanner scan) {
        while (true) {
            System.out.println("Введите номер телефона для поиска");
            System.out.println("По окончании ввода введите \"finish\"");

            String input = scan.nextLine();
            if (input.equals("finish")) {
                break;
            }
            contacts.showContact(input);
        }
    }
}





