/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

/**
 *
 * @author kokarat
 */
public class FixAccount extends Account {
    private int depositYear;

    public FixAccount() {
        super();
    }

    public FixAccount(int id, double balance) {
        super(id, balance);
    }

    public void setDepositYear(int year) {
        this.depositYear = year;
    }

    public void withdrawWithCheck(double amount, int currentYear) {
        if (currentYear - depositYear >= 1) {
            withdraw(amount);
        }
    }

    @Override
    public void transferMoney(Account acc1, double amount) {
        System.out.println("Cannot transfer money from FixAccount.");
    }
}