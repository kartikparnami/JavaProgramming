/*
Question link: https://www.interviewbit.com/problems/implement-power-function/
 */

import java.util.*;

class Solution {
    public int pow(int x, int n, int d) {
        if (x == 0) {
            return 0;
        }
        long ans = 1, xLong = x;
        xLong = xLong % d;
        while (n > 0) {
//            System.out.println("N: " + n);
            if (n % 2 == 1) {
                ans = (ans * xLong) % d;
            }
            n = n >> 1;
            xLong = (xLong * xLong) % d;
//            System.out.println("Ans: " + ans);
        }
        if (ans < 0) {
            return (int)(ans + d);
        }
        return (int)ans;
    }
}

class Main {
    public static void main(String[] args) {
        int A = 71045970, B = 41535484, C = 64735492;
        Solution sol = new Solution();
//        for (int i = 0; i < 10; i += 1) {
            System.out.println(sol.pow(A, B, C));
//        }
    }
}