/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kokarat
 */
import java.util.Scanner;

public class ConsecutiveFour {

    public boolean isConsecutiveFour(int[][] values) {
        int rows = values.length;
        int cols = values[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 3; j++) {
                if (values[i][j] == values[i][j + 1] &&
                    values[i][j] == values[i][j + 2] &&
                    values[i][j] == values[i][j + 3]) {
                    return true;
                }
            }
        }

        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < cols; j++) {
                if (values[i][j] == values[i + 1][j] &&
                    values[i][j] == values[i + 2][j] &&
                    values[i][j] == values[i + 3][j]) {
                    return true;
                }
            }
        }

        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < cols - 3; j++) {
                if (values[i][j] == values[i + 1][j + 1] &&
                    values[i][j] == values[i + 2][j + 2] &&
                    values[i][j] == values[i + 3][j + 3]) {
                    return true;
                }
            }
        }

        for (int i = 3; i < rows; i++) {
            for (int j = 0; j < cols - 3; j++) {
                if (values[i][j] == values[i - 1][j + 1] &&
                    values[i][j] == values[i - 2][j + 2] &&
                    values[i][j] == values[i - 3][j + 3]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        
        int[][] matrix = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        ConsecutiveFour checker = new ConsecutiveFour();
        boolean result = checker.isConsecutiveFour(matrix);
        
        if (result) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        
        scanner.close();
    }
}