/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8;

/**
 *
 * @author kokarat
 */
public class TestComparableCircle {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(10.0);
        ComparableCircle c2 = new ComparableCircle(15.0);
        
        int result = c1.compareTo(c2);
        if (result > 0) {
            System.out.println("c1 is larger");
        } else if (result < 0) {
            System.out.println("c2 is larger");
        } else {
            System.out.println("c1 and c2 are equal");
        }
    }
}
