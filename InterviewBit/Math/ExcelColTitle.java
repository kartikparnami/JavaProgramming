/*
Question link: https://www.interviewbit.com/problems/excel-column-title/
 */

import java.util.*;

class Solution {
    public String convertToTitle(int A) {
        String answer = "";
        while (A > 0) {
            int b = (int)(A % 26);
            char c;
            if (b == 0) {
                c = 'Z';
                A = (int)(A/26) - 1;
            } else {
                c = (char) ('A' + b - 1);
                A = (int)(A/26);
            }
            answer = c + answer;

        }
        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        int A = 728;
        Solution sol = new Solution();
        System.out.println(sol.convertToTitle(A));
    }
}