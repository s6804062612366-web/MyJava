import java.util.Scanner;

public class Light {

    // method
    public static int calculateTotalHits(int[][] ships, int[] lights) {
        int totalHits = 0;
        
        for (int i = 0; i < lights.length; i++) {
            int lightX = lights[i];
            
            for (int j = 0; j < ships.length; j++) {
                if (lightX > ships[j][0] && lightX < ships[j][1]) {
                    totalHits++;
                }
            }
        }
        
        return totalHits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); 
        int m = scanner.nextInt(); 
        
        int[][] ships = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            ships[i][0] = Math.min(x1, x2);
            ships[i][1] = Math.max(x1, x2);
        }
     
        int[] lights = new int[m];
        for (int i = 0; i < m; i++) {
            lights[i] = scanner.nextInt();
        }
        
        int result = calculateTotalHits(ships, lights);
        System.out.println(result);
        
        scanner.close();
    }
}