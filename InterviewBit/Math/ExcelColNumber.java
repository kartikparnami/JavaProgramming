/*
Question link: https://www.interviewbit.com/problems/excel-column-number/
 */

import java.util.*;

class Solution {
    public int titleToNumber(String A) {
        int colNum = 0;
        for (int i = 0; i < A.length(); i += 1) {
            Character c = A.charAt(A.length() - i - 1);
            int diffFromA = c.compareTo('A');
            colNum += ((diffFromA + 1) * (Math.pow(26, i)));
        }
        return colNum;
    }
}

class Main {
    public static void main(String[] args) {
        String A = "AZZ";
        Solution sol = new Solution();
        System.out.println(sol.titleToNumber(A));
    }
}