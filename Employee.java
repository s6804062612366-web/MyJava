/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public abstract class Employee {
    private String firstname;
    private String lastname;
    private String id;

    public Employee(String firstname, String lastname, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    public abstract double earning();
    public abstract double bonus(int year);

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}

class SalariedEmployee extends Employee {
    private double salary;
    
    public SalariedEmployee(String firstname,String lastname,String id, double sal) {
        super(firstname, lastname, id);
        this.salary = sal;
    }
    @Override
    public double bonus(int year) {
        if (year > 5) {
            return salary * 12;
        } else {
            return salary * 6;
        }
    }

    @Override
    public double earning() {
        return salary - (salary * 0.05);
    }
}

class ComEmployee extends Employee {
    private double grossSale;
    private double ComRate;
    
    public ComEmployee(String firstname,String lastname,String id, double sales, double percent) {
        super(firstname, lastname, id);
        
        this.grossSale = sales;
        this.ComRate = percent; 
    }
    
    @Override
    public double bonus (int year) {
        if(year > 5) {
            return grossSale * 6;
        } else {
            return grossSale * 3;
        }
    }
    
    @Override
    public double earning () {
        return grossSale+(grossSale * ComRate);
    }
}

