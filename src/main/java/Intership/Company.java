package Intership;

import java.util.ArrayList;

public class Company {
    private String NIP;
    private String name;
    private String address;
    private ArrayList<String> emailAddresses;
    private ArrayList<String> phoneNumbers;

    public String getNIP() { return NIP; }

    public void setNIP(String NIP) { this.NIP = NIP; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public ArrayList<String> getEmailAddresses() { return emailAddresses; }

    public void setEmailAddresses(ArrayList<String> emailAddresses) { this.emailAddresses = emailAddresses; }

    public ArrayList<String> getPhoneNumbers() { return phoneNumbers; }

    public void setPhoneNumbers(ArrayList<String> phoneNumbers) { this.phoneNumbers = phoneNumbers; }

    public void addPhoneNumber(String phoneNumber) { phoneNumbers.add(phoneNumber); }

    public void addEmailAddress(String emailAddress) { emailAddresses.add(emailAddress); }

    public Company() { }

    public Company(String NIP, String name, String address) {
        this.NIP = NIP;
        this.name = name;
        this.address = address;
        this.phoneNumbers = new ArrayList<String>();
        this.emailAddresses = new ArrayList<String>();
    }
}
