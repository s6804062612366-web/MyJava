/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

import java.util.Scanner;

/**
 *
 * @author kokarat
 */
public class ConsecutiveFour {
    private int r;
    private int c;
    private int[][] values;
    
    public static boolean isConsecutiveFour(int[][] values) {
        int r = values.length;
        int c = values[0].length;
        
        //scan rows
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c-3; j++) {
                
                if ((values[i][j] == values[i][j+1]) 
                        && (values[i][j+1] == values[i][j+2]) 
                        && (values[i][j+2] == values[i][j+3])) {
                    return true;
                }
            }
        }
        
        //scan cols
        for(int i = 0; i < r-3; i++) {
            for(int j = 0; j < c; j++) {
                
                if ((values[i][j] == values[i+1][j]) 
                        && (values[i+1][j] == values[i+2][j]) 
                        && (values[i+2][j] == values[i+3][j])) {
                    return true;
                }
            }
        }
        
        for(int i = 0; i < r-3; i++) {
            for(int j = 0; j < c-3; j++) {
                
                if ((values[i][j] == values[i+1][j+1]) 
                        && (values[i+1][j+1] == values[i+2][j+2]) 
                        && (values[i+2][j+2] == values[i+3][j+3])) {
                    return true;
                }
            }
        }
        
        for(int i = 0; i < r-3; i++) {
            for(int j = 3; j < c; j++) {
                
                if ((values[i][j] == values[i+1][j-1]) 
                        && (values[i+1][j-1] == values[i+2][j-2]) 
                        && (values[i+2][j-2] == values[i+3][j-3])) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] values = new int[r][c];
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                values[i][j] = sc.nextInt();
            }
        }
        
        if(isConsecutiveFour(values)) { 
            System.out.print("1"); 
        } else {
            System.out.print("0");
        }
        sc.close();
    }
}
