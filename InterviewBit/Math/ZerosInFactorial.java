/*
Question link: https://www.interviewbit.com/problems/trailing-zeros-in-factorial/
 */

import java.util.*;

class Solution {
    public int trailingZeroes(int A) {
        int zeros = 0;
        for (int i = 1; Math.pow(5, i) <= A; i += 1) {
            zeros += Math.floor(A/Math.pow(5, i));
        }
        return zeros;
    }
}

class Main {
    public static void main(String[] args) {
        int A = 25;
        Solution sol = new Solution();
        System.out.println(sol.trailingZeroes(A));
    }
}