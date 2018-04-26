package Intership;

import java.util.ArrayList;

public class Customer {
    private String id;
    private String name;
    private String surname;
    private String address;
    private ArrayList<String> emailAddresses;
    private ArrayList<String> phoneNumbers;
    private ArrayList<String> loginList;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public ArrayList<String> getEmailAddresses() { return emailAddresses; }

    public void setEmailAddresses(ArrayList<String> emailAddresses) { this.emailAddresses = emailAddresses; }

    public ArrayList<String> getPhoneNumbers() { return phoneNumbers; }

    public void setPhoneNumbers(ArrayList<String> phoneNumbers) { this.phoneNumbers = phoneNumbers; }

    public ArrayList<String> getLoginList() { return loginList; }

    public void setLoginList(ArrayList<String> loginList) { this.loginList = loginList; }

    public void addLogin(String login) { loginList.add(login); }

    public void addPhoneNumber(String phoneNumber) { phoneNumbers.add(phoneNumber); }

    public void addEmailAddress(String emailAddress) { emailAddresses.add(emailAddress); }

    public Customer() { }

    public Customer(String id, String name, String surname, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.loginList = new ArrayList<String>();
        this.phoneNumbers = new ArrayList<String>();
        this.emailAddresses = new ArrayList<String>();
    }
}
