/*
Question link: https://www.interviewbit.com/problems/maximum-consecutive-gap/
For O(n) solution, use pidgeonhole principle and buckets.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int maximumGap(final List<Integer> A) {
        int maxGap = 0;
        Collections.sort(A);
        for (int i = 1; i < A.size(); i += 1) {
            int gap = Math.abs(A.get(i) - A.get(i - 1));
            maxGap = Math.max(maxGap, gap);
        }
        return maxGap;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 2, 4));
        Solution sol = new Solution();
        System.out.println(sol.maximumGap(input));
    }
}