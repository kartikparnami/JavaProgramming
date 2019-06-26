/*
Question link: https://www.interviewbit.com/problems/sorted-permutation-rank/
 */

import java.util.*;

class Solution {
    public String sortString(String A) {
        char[] chars = A.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public int factorial(int A) {
        long fac = 1;
        while (A > 0) {
            fac = fac * (long)(A);
            fac = fac % 1000003;
            A -= 1;
        }
        return (int)(fac);
    }

    public int findRank(String A) {
        long fact = 0;
        String overallSorted = sortString(A);
        for (int i = 0; i < A.length(); i += 1) {
            String sorted = sortString(A.substring(i));
            Character one = new Character(A.charAt(i));
            Character two = new Character(sorted.charAt(0));
            int diff = sorted.indexOf(one) - sorted.indexOf(two);
//            System.out.println(sorted + " " + one + " " + two + " " + diff);
            if (diff > 0) {
                long val = (diff * factorial(A.length() - i - 1)) % 1000003;
//                System.out.println(val);
                fact += val;
            }
//            System.out.println("-=-=-=-=-=-=-=");
        }
        fact += 1;
        fact = fact % 1000003;
        return (int)(fact);
    }
}

class Main {
    public static void main(String[] args) {
        String A = "VIEW";
        Solution sol = new Solution();
        System.out.println(sol.findRank(A));
    }
}