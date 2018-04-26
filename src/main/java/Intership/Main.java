package Intership;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File baza = new File("database.tsv");
        Scanner in = new Scanner(baza);
        int counter = 0;
        Tool.createDirectories();

        ArrayList<Customer> customers = new ArrayList<Customer>();
        ArrayList<Company> companies = new ArrayList<Company>();
        Tool.fillLists(customers, companies);
        ArrayList<String> toSave = new ArrayList<String>();


        while (in.hasNextLine()){
            ++counter;
            Scanner line = new Scanner(in.nextLine());
            ArrayList<String> entry = new ArrayList<String>();
            while (line.hasNext()){
                entry.add(line.next());
            }
            if (Tool.processEntry(entry, customers, companies, toSave) == 1) System.err.println("Niepoprawne dane w linii nr: " + counter);

            line.close();
        }
        in.close();

        //zapis wszystkich klientów i firm do struktury -> zrób liste modyfikowanych i nowych i nadpisz tylko tych
    }
}
