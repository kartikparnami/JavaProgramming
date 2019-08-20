/*
Question link: https://www.interviewbit.com/problems/implement-strstr/
 */

import java.util.*;

class Solution {
    public int strStr(final String A, final String B) {
        int[] lps = new int[B.length()];
        int j = 0;
        lps[0] = 0;
        for (int i = 1; i < B.length(); i += 1) {
            if (B.charAt(j) == B.charAt(i)) {
                j += 1;
                lps[i] = j;
            } else {
                while (B.charAt(j) != B.charAt(i)) {
                    if (j > 0) {
                        j = lps[j - 1];
                    } else {
                        lps[i] = 0;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < lps.length; i += 1) {
            System.out.println(lps[i]);
        }
        j = 0;
        for (int i = 0; i < A.length(); i += 1) {
            if (j == B.length()) {
                return i - j;
            } else {
                if (A.charAt(i) == B.charAt(j)) {
                    j += 1;
                } else {
                    while (B.charAt(j) != A.charAt(i)) {
                        System.out.println(j + " " + i);
                        if (j > 0) {
                            j = lps[j - 1];
                        } else {
                            break;
                        }
                    }
                    if (B.charAt(j) == A.charAt(i)) {
                        j += 1;
                    }
                }
            }
        }
        if (j == B.length()) {
            return A.length() - j;
        } else {
            return -1;
        }
    }
}

class Main {
    public static void main(String[] args) {
        String A = "aabaaabaaac";
        String B = "aabaaac";
        Solution sol = new Solution();
        System.out.println(sol.strStr(A, B));
    }
}