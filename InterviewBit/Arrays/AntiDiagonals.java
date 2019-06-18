/*
Question link: https://www.interviewbit.com/problems/anti-diagonals/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        for (int i = 0; i < A.size(); i += 1) {
            ArrayList<Integer> b = new ArrayList<>();
            int currX = i, currY = 0;
            while (currX >= 0 && currY < A.size()) {
                b.add(A.get(currY).get(currX));
                currX -= 1;
                currY += 1;
            }
            sol.add(b);
        }
        for (int i = 1; i < A.size(); i += 1) {
            ArrayList<Integer> b = new ArrayList<>();
            int currX = A.size() - 1, currY = i;
            while (currX >= 0 && currY < A.size()) {
                b.add(A.get(currY).get(currX));
                currX -= 1;
                currY += 1;
            }
            sol.add(b);
        }
        return sol;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> i1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        input.add(i1);
        i1 = new ArrayList<>(Arrays.asList(4, 5, 6));
        input.add(i1);
        i1 = new ArrayList<>(Arrays.asList(7, 8, 9));
        input.add(i1);
        Solution sol = new Solution();
        System.out.println(sol.diagonal(input));
    }
}