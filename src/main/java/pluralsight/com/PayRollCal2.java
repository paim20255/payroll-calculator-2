package pluralsight.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class PayRollCal2 {
    public static void main(String[] args) {
        String fileName = "src/main/resources/employees.csv";

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            while (line != null) {
                String[] linePart = line.split(Pattern.quote("|"));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Sorry mate, that file doesn't exist: " + fileName);
        } catch (IOException e) {
            System.out.println("Not sure what's up, some kinda I/O problem");
        }


    }
}
