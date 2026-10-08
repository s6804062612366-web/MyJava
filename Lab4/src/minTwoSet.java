
import java.util.Arrays;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kokarat
 */
public class minTwoSet {
    private int n;
    private int[] w;
    
    //Constuctor
    public minTwoSet (int size, int[] weights) {
        this.n = size;
        this.w = weights;
    }
    
    //Method
    public int findMinDiff() {
        int sumA = 0;
        int sumB = 0;
        
        Arrays.sort(w);
        
        for (int i = n - 1; i >= 0; i--) {
            if (sumA < sumB) {
                sumA += w[i];
            } else {
                sumB += w[i];
            }
        }
        return Math.abs(sumA - sumB);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            
        }
        
        minTwoSet obj = new minTwoSet(n,arr);
        int diff = obj.findMinDiff();
        System.out.print(diff);
        sc.close();
    }
}
