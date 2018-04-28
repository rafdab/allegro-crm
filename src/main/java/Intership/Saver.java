package Intership;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Saver {
    static void saveData(ArrayList<Customer> customers, ArrayList<Company> companies, ArrayList<String> toSave) throws IOException {
        for (String i : toSave){
            for (Customer customer : customers) if (customer.getId().equals(i)) writeCustomer(customer);
            for (Company company : companies) if (company.getNIP().equals(i)) writeCompany(company);
        }
    }

    private static void deleteDirectory(Path path, String dirName){
        if (Files.exists(path)){
            File dir = new File(dirName);
            File[] files = dir.listFiles();
            for (File f : files) f.delete();
            dir.delete();
        }

    }

    private static void writeCustomer(Customer customer) throws IOException {
        String dirName = ("./output/customers/" + customer.getId());
        Path path = Paths.get(dirName);
        deleteDirectory(path, dirName);
        try {
            Files.createDirectory(path); }
            catch (IOException e) {
                System.err.println("Odmowa dostępu");
            }

        File data = new File(dirName + "/data.txt");
        File email = new File(dirName + "/email.txt");
        File phone = new File(dirName + "/phone.txt");
        File login = new File(dirName + "/login.txt");

        FileWriter datafileWriter = new FileWriter(data.getAbsoluteFile());
        BufferedWriter databufferedWriter = new BufferedWriter(datafileWriter);
        databufferedWriter.write(customer.getName());
        databufferedWriter.write("\n" + customer.getSurname());
        databufferedWriter.write("\n" + customer.getAddress());
        databufferedWriter.close();
        datafileWriter.close();

        FileWriter emailWriter = new FileWriter(email.getAbsoluteFile());
        BufferedWriter emailBWriter = new BufferedWriter(emailWriter);
        for (String e : customer.getEmailAddresses()) emailBWriter.write(e + "\n");
        emailBWriter.close();
        emailWriter.close();

        FileWriter phoneWriter = new FileWriter(phone.getAbsoluteFile());
        BufferedWriter phoneBWriter = new BufferedWriter(phoneWriter);
        for (String p : customer.getPhoneNumbers()) phoneBWriter.write(p + "\n");
        phoneBWriter.close();
        phoneWriter.close();

        FileWriter loginWriter = new FileWriter(login.getAbsoluteFile());
        BufferedWriter loginBWriter = new BufferedWriter(loginWriter);
        for (String l : customer.getLoginList()) loginBWriter.write(l + "\n");
        loginBWriter.close();
        loginWriter.close();
    }

    private static void writeCompany(Company company) throws IOException {
        String dirName = ("./output/companies/" + company.getNIP());
        Path path = Paths.get(dirName);
        deleteDirectory(path, dirName);
        try {
            Files.createDirectory(path); }
        catch (IOException e) {
            System.err.println("Odmowa dostępu");
        }

        File data = new File(dirName + "/data.txt");
        File email = new File(dirName + "/email.txt");
        File phone = new File(dirName + "/phone.txt");

        FileWriter datafileWriter = new FileWriter(data.getAbsoluteFile());
        BufferedWriter databufferedWriter = new BufferedWriter(datafileWriter);
        databufferedWriter.write(company.getName());
        databufferedWriter.write("\n" + company.getAddress());
        databufferedWriter.close();
        datafileWriter.close();

        FileWriter emailWriter = new FileWriter(email.getAbsoluteFile());
        BufferedWriter emailBWriter = new BufferedWriter(emailWriter);
        for (String e : company.getEmailAddresses()) emailBWriter.write(e + "\n");
        emailBWriter.close();
        emailWriter.close();

        FileWriter phoneWriter = new FileWriter(phone.getAbsoluteFile());
        BufferedWriter phoneBWriter = new BufferedWriter(phoneWriter);
        for (String p : company.getPhoneNumbers()) phoneBWriter.write(p + "\n");
        phoneBWriter.close();
        phoneWriter.close();

    }
}
