/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kokarat
 */
import java.util.Scanner;

public class KIBcom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        int[][] cityMap = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cityMap[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println(findMaxPopulation(cityMap, k, m, n));
    }

    public static int findMaxPopulation(int[][] cityMap, int k, int m, int n) {
        int maxPop = 0;
        
        for (int r = 0; r <= m-k; r++) {
            for (int c = 0; c <= n-k; c++) {
                int currentPop = 0;
                
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < k; j++) {
                        currentPop += cityMap[r+i][c+j];
                    }
                }
                
                if (currentPop > maxPop) {
                    maxPop = currentPop;
                }
            }
        }
        return maxPop;
    }
}
