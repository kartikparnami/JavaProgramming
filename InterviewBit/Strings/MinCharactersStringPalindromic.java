/*
Question link: https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/
 */

import java.util.*;

class Solution {
    private boolean isPalindrome(String B) {
//        System.out.println(B);
        for (int i = 0; i < B.length()/2 ; i += 1) {
            if (B.charAt(i) != B.charAt(B.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public int solve(String A) {
        for (int i = 0; i < A.length(); i += 1) {
            if (isPalindrome(A.substring(0, A.length() - i))) {
                return i;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        String A = "AACECAAAA";
        Solution sol = new Solution();
        System.out.println(sol.solve(A));
    }
}