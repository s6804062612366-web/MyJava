/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kokarat
 */
import java.util.ArrayList;
import java.util.Scanner;

public class SortMergeList {

    public ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            int val1 = list1.get(i);
            int val2 = list2.get(j);
            
            if (val1 == val2) {
                result.add(val1);
                i++;
                j++;
            } else if (val1 < val2) {
                i++;
            } else {
                j++;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        while (scanner.hasNextInt()) {
            int val = scanner.nextInt();
            if (val == 0) {
                break;
            }
            list1.add(val);
        }
        
        while (scanner.hasNextInt()) {
            int val = scanner.nextInt();
            if (val == 0) {
                break;
            }
            list2.add(val);
        }
        
        SortMergeList sorter = new SortMergeList();
        ArrayList<Integer> result = sorter.intersect(list1, list2);
        
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(" ");
            }
        }
        
        scanner.close();
    }
}
