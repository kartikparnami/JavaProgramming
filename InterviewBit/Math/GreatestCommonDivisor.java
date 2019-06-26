/*
Question link: https://www.interviewbit.com/problems/greatest-common-divisor/
 */

import java.util.*;

class Solution {
    public int gcd(int A, int B) {
        if (A == 0) {
            return B;
        }
        return gcd(B % A, A);
    }
}

class Main {
    public static void main(String[] args) {
        int A = 12;
        int B = 8;
        Solution sol = new Solution();
        System.out.println(sol.gcd(A, B));
    }
}