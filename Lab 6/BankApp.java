/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

/**
 *
 * @author kokarat
 */
public class BankApp {
    public static void main(String[] args) {
        Account targetAcc = new Account(1100, 0);

        SavingAccount acc1 = new SavingAccount(1123, 20000);
        acc1.setAnnualInterestRate(4.5);
        Person p1 = new Person("Somchai", "Jaidee");
        p1.setAge(25);
        p1.setBDate(new Date(1, "January", 2000));
        acc1.setObjPerson(p1);

        acc1.withdraw(2500);
        acc1.deposit(3000);
        acc1.transferMoney(targetAcc, 1000);

        System.out.println(acc1.getBalance());
        System.out.println(acc1.getMonthlyInterest());

        FixAccount acc2 = new FixAccount(1124, 20000);
        acc2.setAnnualInterestRate(7.0);
        Person p2 = new Person("Somsri", "Deejai");
        p2.setAge(30);
        p2.setBDate(new Date(5, "May", 1995));
        acc2.setObjPerson(p2);

        acc2.setDepositYear(2025);
        acc2.withdrawWithCheck(2500, 2026);
        acc2.deposit(3000);
        acc2.transferMoney(targetAcc, 1000);

        System.out.println(acc2.getBalance());
        System.out.println(acc2.getMonthlyInterest());
    }
}