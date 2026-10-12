package lab8;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kokarat
 */
public class TestHouse {
    public static void main(String[] args) {
        House house1 = new House(1, 1750.50);
        House house2 = (House) house1.clone();
        
        System.out.println("House 1 -> ID: " + house1.getId() + ", Area: " + house1.getArea());
        System.out.println("House 2 -> ID: " + house2.getId() + ", Area: " + house2.getArea());
        
        System.out.println("Is house1 the exact same object as house2? : " + (house1 == house2));
    }
}
