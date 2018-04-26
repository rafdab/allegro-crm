package Intership;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File baza = new File("database.tsv");
        Scanner in = new Scanner(baza);
        int counter = 0;

        while (in.hasNextLine()){
            ++counter;
            Scanner line = new Scanner(in.nextLine());
            ArrayList<String> entry = new ArrayList<String>();

            while (line.hasNext()){
                entry.add(line.next());
            }

            if (Tool.getEntry(entry) == 1) System.out.println("Niepoprawne dane w linii nr: " + counter);

            line.close();
        }
        in.close();
    }
}
