package Intership;

import java.util.ArrayList;

public class Tool {

    private static String concatAddress(ArrayList<String> entry, int argc){
        String address = entry.get(argc-4);
        for (int i = argc - 3; i < argc; ++i){
            address += " ";
            address += entry.get(i);

        }
        return address;
    }

    private static int saveCustomer(ArrayList<String> entry, int argc){
        Customer customer = new Customer(
                entry.get(0),
                entry.get(1),
                entry.get(2),
                concatAddress(entry, argc));

        customer.addLogin(entry.get(4));
        customer.addEmailAddress(entry.get(3));
        customer.addPhoneNumber(entry.get(6));
        if (argc > 10) customer.addPhoneNumber(entry.get(7));

        return 0;
    }

    private static int saveCompany(ArrayList<String> entry, int argc){
        Company company = new Company(
                entry.get(0),
                entry.get(1),
                concatAddress(entry, argc));

        company.addEmailAddress(entry.get(2));
        company.addPhoneNumber(entry.get(4));
        if (argc > 8) company.addPhoneNumber(entry.get(5));

        return 0;
    }

    static int getEntry(ArrayList<String> entry){
        switch (entry.size()){
            case 10: return saveCustomer(entry, 10);
            case 11: return saveCustomer(entry, 11);
            case 8: return saveCompany(entry, 8);
            case 9: return saveCompany(entry, 9);
        }
        return 1;
    }
}
