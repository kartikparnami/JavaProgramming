/*
Question link: https://www.interviewbit.com/problems/power-of-two-integers/
https://www.geeksforgeeks.org/check-if-a-number-can-be-expressed-as-ab-set-2/
 */

import java.util.*;

class Solution {
    public int isPower(int A) {
        if (A == 1)
            return 1;

        for (int i = 2; i * i <= A; i++) {
            double val = Math.log(A) / Math.log(i);
            if ((val - (int)val) < 0.00000001)
                return 1;
        }

        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        int A = 125;
        Solution sol = new Solution();
        System.out.println(sol.isPower(A));
    }
}