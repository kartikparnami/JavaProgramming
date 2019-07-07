/*
Question link: https://www.interviewbit.com/problems/palindrome-string/
 */

import java.util.*;

class Solution {
    public int isPalindrome(String A) {
        String B = A.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(B);
        strBuild = strBuild.reverse();
        for (int i = 0; i < B.length(); i += 1) {
            if (B.charAt(i) != strBuild.charAt(i)) {
                return 0;
            }
        }
        return 1;
    }
}

class Main {
    public static void main(String[] args) {
        String A = "A man, a plan, a canal: Panama";
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(A));
    }
}