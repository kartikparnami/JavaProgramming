/*
Question link: https://www.interviewbit.com/problems/matrix-search/
 */

import java.util.*;

class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        ArrayList<Integer> firstCol = new ArrayList<>();
        for (int i = 0; i < a.size(); i += 1) {
            firstCol.add(a.get(i).get(0));
        }
        int row = Arrays.binarySearch(firstCol.toArray(), b);
//        System.out.println("row: " + row);
        if (row >= 0) {
            return 1;
        } else {
            int rowNum = Math.abs(row + 1) - 1;
            if (rowNum < 0) {
                return 0;
            }
            int col = Arrays.binarySearch(a.get(rowNum).toArray(), b);
//            System.out.println("rowNum " + rowNum + " col: " + col);
            if (col >= 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7)));
        A.add(new ArrayList<Integer>(Arrays.asList(10, 11, 16, 20)));
        A.add(new ArrayList<Integer>(Arrays.asList(23, 30, 34, 50)));
        int B = 7;
        Solution sol = new Solution();
        System.out.println(sol.searchMatrix(A, B));
    }
}