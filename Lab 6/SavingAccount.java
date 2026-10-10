/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

/**
 *
 * @author kokarat
 */
public class SavingAccount extends Account {
    public SavingAccount() {
        super();
    }

    public SavingAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void transferMoney(Account acc1, double amount) {
        if (getBalance() >= amount + 20) {
            setBalance(getBalance() - (amount + 20));
            acc1.deposit(amount);
        }
    }
}