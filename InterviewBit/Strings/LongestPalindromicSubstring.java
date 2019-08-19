/*
Question link: https://www.interviewbit.com/problems/longest-palindromic-substring/
 */

import java.util.*;

class Solution {
    public String longestPalindrome(String A) {
        String longest = A.substring(0, 1);
        for (int i = 0; i < A.length(); i += 1) {
            String current = "";
            for (int j = 0; j < A.length(); j += 1) {
                if ((i + j < A.length()) && (i - j) >= 0) {
                    if (A.charAt(i + j) == A.charAt(i - j)) {
                        current = A.substring(i - j, i + j + 1);
                    } else {
                        break;
                    }
                }
            }
            if (current.length() > longest.length()) {
                longest = current;
            }
        }
        for (int i = 1; i < A.length(); i += 1) {
            if (A.charAt(i - 1) == A.charAt(i)) {
                String current = A.substring(i - 1, i + 1);
                for (int j = 0; j < A.length(); j += 1) {
                    if ((i - 1 - j >= 0) && (i + j < A.length())) {
                        if (A.charAt(i - 1 - j) == A.charAt(i + j)) {
                            current = A.substring(i - 1 - j, i + j + 1);
                        } else {
                            break;
                        }
                    }
                }
                if (current.length() > longest.length()) {
                    longest = current;
                }
            }
        }
        return longest;
    }
}

class Main {
    public static void main(String[] args) {
        String A = "BBAACEECAAAA";
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome(A));
    }
}