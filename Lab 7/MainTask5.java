/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

/**
 *
 * @author kokarat
 */
public class MainTask5 {
    public static void main(String[] args) {
        Address address = new Address();
        address.setStreet("123 Sukhumvit Road");
        address.setCity("Bangkok");

        Employee emp = new Manager();
        emp.setId(1001);
        emp.setName("Somchai");
        emp.setSalary(55000.00);
        emp.setAddress(address);

        if (emp instanceof Manager) {
            ((Manager) emp).setParkingNo("VIP-A01");
        }

        System.out.println(emp.getDetails());
    }
}