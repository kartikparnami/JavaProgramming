/*
Question link: https://www.interviewbit.com/problems/square-root-of-integer/
 */

import java.util.*;

class Solution {
    public int sqrt(int a) {
        long start = 0, end = a;
        while (start <= end) {
//            System.out.println(start + " " + end);
            long mid = start + (end - start)/2;
            if (mid * mid > a) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start * start == a) {
            return (int)start;
        } else {
            return (int)(start - 1);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int i = 0; i < 100; i += 1) {
            System.out.println(i + " " + sol.sqrt(i));
//            System.out.println("-=-=-=-=-=-=-=-");
        }
    }
}