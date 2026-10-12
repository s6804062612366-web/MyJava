/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8;

/**
 *
 * @author kokarat
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Subway {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, ArrayList<Integer>> stationToLines = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            for (int j = 0; j < s; j++) {
                int station = Integer.parseInt(st.nextToken());
                stationToLines.putIfAbsent(station, new ArrayList<>());
                stationToLines.get(station).add(i);
            }
        }

        ArrayList<Integer>[] adjLines = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            adjLines[i] = new ArrayList<>();
        }

        for (ArrayList<Integer> lines : stationToLines.values()) {
            for (int i = 0; i < lines.size(); i++) {
                for (int j = i + 1; j < lines.size(); j++) {
                    int u = lines.get(i);
                    int v = lines.get(j);
                    if (!adjLines[u].contains(v)) {
                        adjLines[u].add(v);
                        adjLines[v].add(u);
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < q; k++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == b) {
                sb.append("0\n");
                continue;
            }

            ArrayList<Integer> startLines = stationToLines.get(a);
            ArrayList<Integer> endLines = stationToLines.get(b);

            if (startLines == null || endLines == null) {
                sb.append("impossible\n");
                continue;
            }

            boolean[] isTarget = new boolean[m];
            for (int line : endLines) {
                isTarget[line] = true;
            }

            Queue<Integer> queue = new LinkedList<>();
            int[] dist = new int[m];
            for (int i = 0; i < m; i++) {
                dist[i] = -1;
            }

            boolean found = false;
            for (int line : startLines) {
                queue.add(line);
                dist[line] = 0;
                if (isTarget[line]) {
                    sb.append("0\n");
                    found = true;
                    break;
                }
            }

            if (found) continue;

            while (!queue.isEmpty()) {
                int currentLine = queue.poll();

                if (isTarget[currentLine]) {
                    sb.append(dist[currentLine]).append("\n");
                    found = true;
                    break;
                }

                for (int nextLine : adjLines[currentLine]) {
                    if (dist[nextLine] == -1) {
                        dist[nextLine] = dist[currentLine] + 1;
                        queue.add(nextLine);
                    }
                }
            }

            if (!found) {
                sb.append("impossible\n");
            }
        }
        System.out.print(sb.toString());
    }
}