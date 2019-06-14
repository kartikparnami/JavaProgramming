/*
Question link: https://www.interviewbit.com/problems/noble-integer/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        for (int i = 0; i < A.size(); i += 1) {
            if (A.get(i) == (A.size() - 1 - i)) {
                if ((i < A.size() - 1) && (A.get(i + 1) == A.get(i))) {
                } else {
                    return 1;
                }
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 2, 4));
        Solution sol = new Solution();
        System.out.println(sol.solve(input));
    }
}