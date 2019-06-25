/*
Question link: https://www.interviewbit.com/problems/palindrome-integer/
 */

import java.util.*;

class Solution {
    public int isPalindrome(int A) {
        int B = A;
        int C = 0;
        while (B > 0) {
            C *= 10;
            C = C + (B % 10);
            B /= 10;
        }
        if (C == A) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Main {
    public static void main(String[] args) {
        int A = 0;
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(A));
    }
}