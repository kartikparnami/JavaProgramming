/*
Question link: https://www.interviewbit.com/problems/count-and-say/
 */

import java.util.*;

class Solution {
    public String countAndSay(int A) {
        if (A == 1) {
            return "1";
        }
        if (A == 2) {
            return "11";
        }
        StringBuilder prev = new StringBuilder();
        prev.append("11");
        StringBuilder next = new StringBuilder();
        for (int i = 3; i <= A; i += 1) {
            int startPt = 0;
            for (int j = 1; j < prev.length(); j += 1) {
                if (prev.charAt(j) != prev.charAt(j - 1)) {
                    next.append(j - startPt);
                    next.append(prev.charAt(j - 1));
                    startPt = j;
                }
            }
            next.append(prev.length() - startPt);
            next.append(prev.charAt(prev.length() - 1));
            prev = next;
            next = new StringBuilder();
        }
        return prev.toString();
    }
}

class Main {
    public static void main(String[] args) {
        int A = 40;
        Solution sol = new Solution();
        System.out.println(sol.countAndSay(A));
    }
}