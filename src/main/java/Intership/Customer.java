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

    public String getCurrentEmail(){ return emailAddresses.get(emailAddresses.size() - 1); }

    public String getCurrentPhone(){ return phoneNumbers.get(phoneNumbers.size() - 1); }

    public String getCurrentLogin(){ return loginList.get(loginList.size() - 1); }

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

    private void checkEmail(String email, ArrayList<Customer> customers, ArrayList<Company> companies){
        for (Customer customer : customers) {
            if (customer.getCurrentEmail().equals(email)) customer.addEmailAddress("OUTDATED");
        }
        for (Company company : companies){
            if (company.getCurrentEmail().equals(email)) company.addEmailAddress("OUTDATED");
        }
    }

    public String prepareObject(ArrayList<Customer> customers, ArrayList<Company> companies){
        //aktualizacja
        int couter = 0;
        for (Customer tmp : customers){
            if (this.id.equals(tmp.id)){
                ++couter;
                if (tmp.equals(this)) return "EQUAL";
                tmp.setName(getName());
                tmp.setSurname(getSurname());
                tmp.setAddress(getAddress());
                checkEmail(getCurrentEmail(), customers, companies);
                tmp.addEmailAddress(getCurrentEmail());
                if (!tmp.getCurrentPhone().equals(getCurrentPhone())) tmp.addPhoneNumber(getCurrentPhone());
                if (!tmp.getCurrentLogin().equals(getCurrentLogin())) tmp.addLogin(getCurrentLogin());
            }
        }
        if (couter == 0) customers.add(this);
        return getId();
    }
}
