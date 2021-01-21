package application;

import model.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        List<Employee> list = new ArrayList<>();
        String path = "d:\\Languages-ws\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String employeeData = br.readLine();
            while (employeeData != null) {
                String[] fields = employeeData.split(",");
                list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                employeeData = br.readLine();
            }
            Collections.sort(list);
            for (Employee emp : list) {
                System.out.println(emp.getName() + "," + emp.getSalary());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
