package week4;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public abstract class Phone {

    protected List<Integer> callHistory = new ArrayList<>();
    protected Map<String, List<String>> messageHistory = new HashMap<>();
    protected List<Contact> contacts = new ArrayList<>();
    protected int batteryLife;

    public Phone() {
    }

    public Phone(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public void addContact(String contactNumber, String phoneNumber, String firstName, String lastName) {
        contacts.add(new Contact(contactNumber, phoneNumber, firstName, lastName));
    }

    public void viewHistory() {
        callHistory.forEach(call -> System.out.println("Called: " + call));
    }

    public void call(String phoneNumber) {
        if (batteryLife >= 2) {
            System.out.println("Calling " + phoneNumber);
            batteryLife -= 2;
        } else {
            System.out.println("Not enough battery to make this phone call");
        }
    }

    public void sendMessage(String phoneNumber, String message) {
        if (message.length() > 500) {
            throw new IllegalArgumentException("Character limit exceeded. Message must not be longer than 500 characters.");
        } else if (batteryLife >= 1) {
            messageHistory.computeIfAbsent(phoneNumber, k -> new ArrayList<>());
            messageHistory.get(phoneNumber).add(message);
            System.out.println("Message sent...");
            batteryLife--;
        } else if (batteryLife == 0) {
            System.out.println("Not enough battery to send this message");
        }
    }

    public void getFirstContact() {
        System.out.println(contacts.get(0));
    }

    public void getSecondContact() {
        System.out.println(contacts.get(1));
    }

    public void getFirstMessage(String phoneNumber) {
        System.out.println(messageHistory.get(phoneNumber).get(0));
    }

    public void getSecondMessage(String phoneNumber) {
        System.out.println(messageHistory.get(phoneNumber).get(1));
    }

}
