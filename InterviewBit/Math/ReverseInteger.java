/*
Question link: https://www.interviewbit.com/problems/reverse-integer/
 */

import java.util.*;

class Solution {
    public int reverse(int A) {
        boolean isNeg = false;
        if ((-1 * A) > 0) {
            isNeg = true;
            A = (-1 * A);
        }
        long C = 0;
        while (A > 0) {
            C *= 10;
            C = C + (A % 10);
            A /= 10;
        }
        if (C > Integer.MAX_VALUE) {
            return 0;
        }
        int CDash = (int)C;
        if (isNeg) {
            return (-1 * CDash);
        } else {
            return CDash;
        }
    }
}

class Main {
    public static void main(String[] args) {
        int A = 1000000001;
        System.out.println(A > Integer.MAX_VALUE);
        Solution sol = new Solution();
        System.out.println(sol.reverse(A));
    }
}