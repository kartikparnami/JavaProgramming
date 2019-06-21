/*
Question link: https://www.interviewbit.com/problems/flip/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> flip(String A) {
        int maxDiffSoFar = 0, maxTillNow = 0, start = -1, end = -1, bestStart = -1, bestEnd = -1;
        for (int i = 0; i < A.length(); i += 1) {
            if (A.charAt(i) == '0') {
                if (start == -1) {
                    start = i;
                }
                maxDiffSoFar += 1;
                if (maxDiffSoFar > maxTillNow) {
                    maxTillNow = maxDiffSoFar;
                    end = i;
                    bestStart = start;
                    bestEnd = i;
                }
            } else {
                maxDiffSoFar -= 1;
                if (maxDiffSoFar < 0) {
                    maxDiffSoFar = 0;
                    start = -1;
                    end = -1;
                }
            }
        }
        if (bestEnd == -1 || bestStart == -1) {
            return new ArrayList<Integer>();
        } else {
            return new ArrayList<Integer>(Arrays.asList(bestStart + 1, bestEnd + 1));
        }
    }
}

class Main {
    public static void main(String[] args) {
        String input = new String("11001010111001");
        Solution sol = new Solution();
        System.out.println(sol.flip(input));
    }
}