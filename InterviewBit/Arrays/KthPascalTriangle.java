/*
Question link: https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> sol = new ArrayList<>();
        sol.add(1);
        if (A == 0) {
            return sol;
        }
        sol.add(1);
        if (A == 1) {
            return sol;
        }
        for (int i = 2; i <= A; i += 1) {
            sol.add(1);
            for (int j = i - 1; j > 0; j -= 1) {
                sol.set(j, sol.get(j) + sol.get(j - 1));
            }
        }
        return sol;
    }
}

class Main {
    public static void main(String[] args) {
        int input = 3;
        Solution sol = new Solution();
        System.out.println(sol.getRow(input));
    }
}