package Intership;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Tool {
    static void fillLists(ArrayList<Customer> customers, ArrayList<Company> companies) throws FileNotFoundException {
        File idList = new File("output/customers/index.txt");
        File NIPList = new File("output/companies/index.txt");

        Scanner idScanner = new Scanner(idList);
        Customer customer = null;
        while (idScanner.hasNextLine()){
            String id = idScanner.nextLine();
            if (!id.equals("")) {
                customer = new Customer();
                customer.setId(id);

                File dataF = new File("output/customers/" + customer.getId() + "/data.txt");
                File emailF = new File("output/customers/" + customer.getId() + "/email.txt");
                File phoneF = new File("output/customers/" + customer.getId() + "/phone.txt");
                File loginF = new File("output/customers/" + customer.getId() + "/login.txt");
                Scanner data = new Scanner(dataF);
                Scanner email = new Scanner(emailF);
                Scanner phone = new Scanner(phoneF);
                Scanner login = new Scanner(loginF);
                ArrayList<String> emailList = new ArrayList<String>();
                ArrayList<String> phoneList = new ArrayList<String>();
                ArrayList<String> loginList = new ArrayList<String>();

                while (email.hasNextLine()) emailList.add(email.nextLine());
                while (phone.hasNextLine()) phoneList.add(phone.nextLine());
                while (login.hasNextLine()) loginList.add(login.nextLine());

                customer.setName(data.nextLine());
                customer.setSurname(data.nextLine());
                customer.setAddress(data.nextLine());
                customer.setEmailAddresses(emailList);
                customer.setPhoneNumbers(phoneList);
                customer.setLoginList(loginList);

                data.close();
                email.close();
                phone.close();
                login.close();

                customers.add(customer);
            }
        }
        idScanner.close();

        Scanner NIPScanner = new Scanner(NIPList);
        Company company = null;
        while (NIPScanner.hasNextLine()) {
            String id = NIPScanner.nextLine();
            if (!id.equals("")) {
                company = new Company();
                company.setNIP(id);

                File dataF = new File("output/companies/" + company.getNIP() + "/data.txt");
                File emailF = new File("output/companies/" + company.getNIP() + "/email.txt");
                File phoneF = new File("output/companies/" + company.getNIP() + "/phone.txt");
                Scanner data = new Scanner(dataF);
                Scanner email = new Scanner(emailF);
                Scanner phone = new Scanner(phoneF);
                ArrayList<String> emailList = new ArrayList<String>();
                ArrayList<String> phoneList = new ArrayList<String>();

                while (email.hasNextLine()) emailList.add(email.nextLine());
                while (phone.hasNextLine()) phoneList.add(phone.nextLine());

                company.setName(data.nextLine());
                company.setAddress(data.nextLine());
                company.setEmailAddresses(emailList);
                company.setPhoneNumbers(phoneList);

                data.close();
                email.close();
                phone.close();

                customers.add(customer);
            }
        }
        NIPScanner.close();
    }

    static void createDirectories(){
        Path path = Paths.get("./output");
        if (Files.notExists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                System.err.println("Odmowa dostępu");
            }
        }

        path = Paths.get("./output/customers");
        if (Files.notExists(path)) {
            try {
                Files.createDirectory(path);
                path = Paths.get("./output/customers/index.txt");
                Files.createFile(path);
            } catch (IOException e) {
                System.err.println("Odmowa dostępu");
            }
        }

        path = Paths.get("./output/companies");
            if (Files.notExists(path)) {
                try {
                    Files.createDirectory(path);
                    path = Paths.get("./output/companies/index.txt");
                    Files.createFile(path);
                } catch (IOException e) {
                    System.err.println("Odmowa dostępu");
                }
            }
    }

    private static String concatAddress(ArrayList<String> entry, int argc){
        String address = entry.get(argc-4);
        for (int i = argc - 3; i < argc; ++i){
            address += " ";
            address += entry.get(i);
        }
        return address;
    }

    private static int saveCustomer(ArrayList<String> entry, int argc, ArrayList<Customer> customers, ArrayList<Company> companies, ArrayList<String> toSave) throws IOException {
        Customer customer = new Customer(
                entry.get(0),
                entry.get(1),
                entry.get(2),
                concatAddress(entry, argc));

        customer.addLogin(entry.get(4));
        customer.addEmailAddress(entry.get(3));
        customer.addPhoneNumber(entry.get(5));
        if (argc > 10) customer.addPhoneNumber(entry.get(6));
        String flag = customer.prepareObject(customers, companies);
        if (!flag.equals("EQUAL"))toSave.add(flag);
        return 0;
    }

    private static int saveCompany(ArrayList<String> entry, int argc, ArrayList<Customer> customers, ArrayList<Company> companies, ArrayList<String> toSave) throws IOException {
        Company company = new Company(
                entry.get(0),
                entry.get(1),
                concatAddress(entry, argc));

        company.addEmailAddress(entry.get(2));
        company.addPhoneNumber(entry.get(3));
        if (argc > 8) company.addPhoneNumber(entry.get(4));
        String flag = company.prepareObject(customers, companies);
        if (!flag.equals("EQUAL"))toSave.add(flag);
        return 0;
    }

    static int processEntry(ArrayList<String> entry, ArrayList<Customer> customers, ArrayList<Company> companies, ArrayList<String> toSave) throws IOException {
        switch (entry.size()){
            case 10: return saveCustomer(entry, 10, customers, companies, toSave);
            case 11: return saveCustomer(entry, 11, customers, companies, toSave);
            case 8: return saveCompany(entry, 8, customers, companies, toSave);
            case 9: return saveCompany(entry, 9, customers, companies, toSave);
        }
        return 1;
    }

}
