/*
Question link: https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/
O(n) solution: https://stackoverflow.com/questions/19557505/triplet-whose-sum-in-range-1-2
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int solve(ArrayList<String> A) {
        ArrayList<Float> a = new ArrayList<Float>();
        for (int i = 0; i < A.size(); i += 1) {
            a.add(Float.parseFloat(A.get(i)));
        }
        Collections.sort(a);
        for (int i = 0; i < a.size() - 2; i += 1) {
            int firstCount = i + 1;
            int lastCount = a.size() - 1;
            while (firstCount < lastCount) {
                float sum = a.get(firstCount) + a.get(i) + a.get(lastCount);
                if (sum > 1 && sum < 2) {
                    return 1;
                } else if (sum <= 1) {
                    firstCount += 1;
                } else {
                    lastCount -= 1;
                }
            }
        }
        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>(Arrays.asList("0.1", "0.2", "0.3", "0.4", "0.4"));
        Solution sol = new Solution();
        System.out.println(sol.solve(input));
    }
}