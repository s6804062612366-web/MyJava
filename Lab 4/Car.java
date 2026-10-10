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
public class Car {
    
    public static boolean drive(int[][] race, int currentTime, int currentLane, int[] moves, int t, int m) {
        
        if (currentTime == t) {
            return true;
        }

        

        
        moves[currentTime] = 1;
        int nextLaneLeft = currentLane - 1;
        
        if (nextLaneLeft >= 0 && race[currentTime][nextLaneLeft] == 0) {
            if (drive(race, currentTime + 1, nextLaneLeft, moves, t, m)) {
                return true;
            }
        }

        
        moves[currentTime] = 2;
        int nextLaneRight = currentLane + 1;
        
        if (nextLaneRight < m && race[currentTime][nextLaneRight] == 0) {
            if (drive(race, currentTime + 1, nextLaneRight, moves, t, m)) {
                return true;
            }
        }

        
        moves[currentTime] = 3;
        int nextLaneStraight = currentLane;
        
        if (race[currentTime][nextLaneStraight] == 0) {
            if (drive(race, currentTime + 1, nextLaneStraight, moves, t, m)) {
                return true;
            }
        }

        
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[][] race = new int[t][m];
        int[] moves = new int[t];
        
        for(int i = 0; i < t; i++) {
            for(int j = 0; j < m; j++) {
                race[i][j] = sc.nextInt();
            }
        }
        
        boolean success = drive(race, 0, n - 1, moves, t, m);
        
        if(success) {
            for(int i = 0; i < t; i++) {
                System.out.println(moves[i]);
            }
        }
    }
}
