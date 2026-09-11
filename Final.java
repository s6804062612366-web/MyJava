/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author student
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Final {

    public static void printEmp(ArrayList<Employee> a) {
        
        double[] arrayEarn = new double[a.size()];
        double[] arrayBonus = new double[a.size()];

        for (int i = 0; i < a.size(); i++) {
            Employee r = a.get(i);
            arrayEarn[i] = r.earning();
            arrayBonus[i] = r.bonus(6); 
        }

        StringBuilder report = new StringBuilder();
        report.append("First name\tLast name\tEarning\t\tBonus\n");
        report.append("--------------------------------------------------------------------------------\n");

        for (int i = 0; i < a.size(); i++) {
            Employee r = a.get(i);
            report.append(r.getFirstname()).append("\t")
                  .append(r.getLastname()).append("\t\t")
                  .append(String.format("%,.2f", arrayEarn[i])).append("\t\t")
                  .append(String.format("%,.2f", arrayBonus[i])).append("\n");
        }

        JOptionPane.showMessageDialog(null, report.toString(), "Employee Report", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        ArrayList<Employee> empList = new ArrayList<>();

        empList.add(new SalariedEmployee("Somchai", "Rakdee", "S001", 30000));
        empList.add(new SalariedEmployee("Somsri", "Jaidee", "S002", 45000));

        empList.add(new ComEmployee("Mana", "Kengmak", "C001", 100000, 0.05));
        empList.add(new ComEmployee("Manee", "Suayngam", "C002", 250000, 0.10));

        printEmp(empList);
    }
} 
