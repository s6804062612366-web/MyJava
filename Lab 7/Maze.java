/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

/**
 *
 * @author kokarat
 */
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int startR = scanner.nextInt() - 1;
        int startC = scanner.nextInt() - 1;
        int endR = scanner.nextInt() - 1;
        int endC = scanner.nextInt() - 1;

        int[][] maze = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

        int[][][] dist = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j][0] = -1;
                dist[i][j][1] = -1;
            }
        }

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(startR, startC, 1, 0));
        dist[startR][startC][0] = 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (maze[nr][nc] == 1) {
                        if (dist[nr][nc][curr.bombed] == -1) {
                            dist[nr][nc][curr.bombed] = curr.dist + 1;
                            queue.add(new State(nr, nc, curr.dist + 1, curr.bombed));
                        }
                    } else if (maze[nr][nc] == 0 && curr.bombed == 0) {
                        if (dist[nr][nc][1] == -1) {
                            dist[nr][nc][1] = curr.dist + 1;
                            queue.add(new State(nr, nc, curr.dist + 1, 1));
                        }
                    }
                }
            }
        }

        int[][] distFromEnd = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distFromEnd[i][j] = -1;
            }
        }

        Queue<State> qEnd = new LinkedList<>();
        qEnd.add(new State(endR, endC, 1, 0));
        distFromEnd[endR][endC] = 1;

        while (!qEnd.isEmpty()) {
            State curr = qEnd.poll();
            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == 1) {
                    if (distFromEnd[nr][nc] == -1) {
                        distFromEnd[nr][nc] = curr.dist + 1;
                        qEnd.add(new State(nr, nc, curr.dist + 1, 0));
                    }
                }
            }
        }

        int minPath = Integer.MAX_VALUE;
        int bombOptions = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i][j] == 0) {
                    boolean fromStart = false;
                    boolean fromEnd = false;

                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == 1) {
                            if (dist[nr][nc][0] != -1) fromStart = true;
                            if (distFromEnd[nr][nc] != -1) fromEnd = true;
                        }
                    }

                    if (fromStart && fromEnd) {
                        bombOptions++;
                        int localMin = Integer.MAX_VALUE;
                        for (int d1 = 0; d1 < 4; d1++) {
                            for (int d2 = 0; d2 < 4; d2++) {
                                int r1 = i + dr[d1];
                                int c1 = j + dc[d1];
                                int r2 = i + dr[d2];
                                int c2 = j + dc[d2];
                                if (r1 >= 0 && r1 < m && c1 >= 0 && c1 < n && maze[r1][c1] == 1 &&
                                    r2 >= 0 && r2 < m && c2 >= 0 && c2 < n && maze[r2][c2] == 1) {
                                    if (dist[r1][c1][0] != -1 && distFromEnd[r2][c2] != -1) {
                                        int p = dist[r1][c1][0] + distFromEnd[r2][c2] + 1;
                                        if (p < localMin) {
                                            localMin = p;
                                        }
                                    }
                                }
                            }
                        }
                        if (localMin < minPath) {
                            minPath = localMin;
                        }
                    }
                }
            }
        }

        if (dist[endR][endC][0] != -1) {
            minPath = Math.min(minPath, dist[endR][endC][0]);
        }

        System.out.println(bombOptions);
        System.out.println(minPath);
        
        scanner.close();
    }
}