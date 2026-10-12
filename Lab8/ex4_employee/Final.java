/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8;

/**
 *
 * @author kokarat
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Final {
    public static void printEmp(ArrayList<Employee> a) {
        double[] arrayEarn = new double[a.size()];
        double[] arrayBonus = new double[a.size()];
        String report = "First name\tLast name\tEarning\tBonus\n";

        for (int i = 0; i < a.size(); i++) {
            Employee r = a.get(i);
            arrayEarn[i] = r.earning();
            arrayBonus[i] = r.bonus(6);
            report += r.getFirstname() + "\t" + r.getLastname() + "\t" + arrayEarn[i] + "\t" + arrayBonus[i] + "\n";
        }
        
        JOptionPane.showMessageDialog(null, report);
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new SalariedEmployee("Somchai", "Jaidee", "E01", 20000));
        employees.add(new SalariedEmployee("Somsri", "Rakdee", "E02", 30000));
        employees.add(new ComEmployee("Mana", "Klaahan", "E03", 100000, 0.05));
        employees.add(new ComEmployee("Manee", "Piamsuk", "E04", 150000, 0.10));
        
        printEmp(employees);
    }
}