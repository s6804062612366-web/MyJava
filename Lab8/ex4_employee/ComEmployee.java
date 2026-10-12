/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8;

/**
 *
 * @author kokarat
 */
public class ComEmployee extends Employee {
    private double grossSale;
    private double comRate;

    public ComEmployee(String firstname, String lastname, String id, double sales, double percent) {
        super(firstname, lastname, id);
        this.grossSale = sales;
        this.comRate = percent;
    }

    @Override
    public double bonus(int year) {
        if (year > 5) {
            return grossSale * 6;
        } else {
            return grossSale * 3;
        }
    }

    @Override
    public double earning() {
        return grossSale + (grossSale * comRate);
    }
}