/*
Question link: https://www.interviewbit.com/problems/pascal-triangle/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        if (A == 0) {
            return B;
        }
        B.add(new ArrayList<Integer>(Arrays.asList(1)));
        if (A == 1) {
            return B;
        }
        B.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
        if (A == 2) {
            return B;
        }
        for (int i = 2; i < A; i += 1) {
            ArrayList<Integer> b = new ArrayList<>();
            b.add(1);
            for (int j = 1; j < i; j += 1) {
                b.add(B.get(i - 1).get(j) + B.get(i - 1).get(j - 1));
            }
            b.add(1);
            B.add(b);
        }
        return B;
    }
}

class Main {
    public static void main(String[] args) {
        int input = 5;
        Solution sol = new Solution();
        System.out.println(sol.solve(input));
    }
}
