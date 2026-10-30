package pluralsight.com;

import java.io.*;
import java.util.regex.Pattern;

public class PayRollCal2 {
    public static void main(String[] args) {
        String fileName = "src/main/resources/employees.csv";
        String outputFileName = "src/main/resources/payroll.csv";

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter writer = new FileWriter(outputFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // create the header
            bufferedWriter.write("id|name|gross pay\n");


            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            while (line != null) {
                Employee employee = parseEmployee(line);


                bufferedWriter.write(String.format("%d|%s|%.2f\n",
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getGrossPay()));

                line = bufferedReader.readLine();

               // bufferedReader.close();
               // bufferedWriter.close();

            }
            bufferedReader.close();
            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("Sorry mate, that file doesn't exist: " + fileName);
        } catch (IOException e) {
            System.out.println("Not sure what's up, some kinda I/O problem");
        }
    }

    private static Employee parseEmployee(String employeeCsv) {
        String[] lineParts = employeeCsv.split(Pattern.quote("|"));

        int id = Integer.parseInt(lineParts[0]);
        String name = lineParts[1];
        double hoursWorked = Double.parseDouble(lineParts[2]);
        double payRate = Double.parseDouble(lineParts[3]);


        return new Employee(id, name, (int) hoursWorked, payRate);
    }
}
