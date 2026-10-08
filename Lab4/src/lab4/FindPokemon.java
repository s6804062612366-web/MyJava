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
public class FindPokemon {
    private int H;
    private int W;
    private int[][] A;
    
    //Constructor
    public FindPokemon (int h, int w, int[][] map) {
        this.H = h;
        this.W = w;
        this.A = map;
    }
    
    //Method
    public int[] findPikachu() {
        int maxSum = -1;
        int bestRow = 0;
        int bestCol = 0;
        
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                
                if (c + 1 < W) {
                    int diff = Math.abs(A[r][c] - A[r][c+1]);
                    int sum = A[r][c] + A[r][c+1];
                    
                    if (diff <= 10 && sum > maxSum) {
                        maxSum = sum;
                        bestRow = r;
                        bestCol = c;
                    }
                }
                
                if (r + 1 < H) {
                    int diff = Math.abs(A[r][c] - A[r+1][c]);
                    int sum = A[r][c] + A[r+1][c];
                    
                    if (diff <= 10 && sum > maxSum) {
                        maxSum = sum;
                        bestRow = r;
                        bestCol = c;
                    }
                }
            }
        }
        return new int[]{bestRow + 1, bestCol + 1};
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[][] map = new int[h][w];
        
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                map[r][c] = sc.nextInt();
            }
        }
        
        FindPokemon obj = new FindPokemon(h, w, map);
        int[] ans = obj.findPikachu();
        
        System.out.print(ans[0] + " " + ans[1]);
        sc.close();
    }
}
