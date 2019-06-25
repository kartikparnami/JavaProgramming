/*
Question link: https://www.interviewbit.com/problems/sum-of-pairwise-hamming-distance/
 */

import java.util.*;

class Solution {
    public int hammingDistance(final List<Integer> A) {
        long[] ones = new long[32];
        for (int j = 0; j < 32; j += 1) {
            ones[j] = 0;
            for (int i = 0; i < A.size(); i += 1) {
                int num = A.get(i) >> j;
                int isOne = num & 1;
                if (isOne == 1) {
                    ones[j] += 1;
                }
            }
        }
        long total = 0;
        for (int i = 0; i < 32; i += 1) {
            total += ones[i] * (A.size() - ones[i]);
            total = total % 1000000007;
        }
        total *= 2;
        total = total % 1000000007;
        return (int)total;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 4, 6));
        Solution sol = new Solution();
        System.out.println(sol.hammingDistance(A));
    }
}