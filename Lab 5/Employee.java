/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kokarat
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Employee {
    private String firstname;
    private String lastname;
    private String id;
    private double salary;

    public Employee(String firstname, String lastname, String id, double sal) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.salary = sal;
    }

    public double earning() {
        return salary * 0.95;
    }

    public double bonus(int year) {
        if (year > 5) {
            return salary * 12;
        } else {
            return salary * 6;
        }
    }

    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
}

class EmployeeApp {
    public static void main(String[] args) {
        ArrayList<Employee> arrayEarn = new ArrayList<>();
        
        arrayEarn.add(new Employee("Somying", "Kingthong", "ID001", 30000));
        arrayEarn.add(new Employee("Somchai", "Jaidee", "ID002", 25000));

        printEmp(arrayEarn);
    }

    public static void printEmp(ArrayList<Employee> a) {
        String result = String.format("%-15s %-15s %-10s %-10s\n", "First name", "Last name", "Earning", "Bonus");
        
        for (Employee emp : a) {
            
            result += String.format("%-15s %-15s %-10.2f %-10.2f\n", 
                emp.getFirstname(), 
                emp.getLastname(), 
                emp.earning(), 
                emp.bonus(6)); 
        }
        
        JOptionPane.showMessageDialog(null, result); 
    }
    
}
