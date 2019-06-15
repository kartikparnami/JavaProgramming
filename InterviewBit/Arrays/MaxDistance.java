/*
Question link: https://www.interviewbit.com/problems/max-distance/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int maximumGap(final List<Integer> A) {
        ArrayList<Integer> LMin = new ArrayList<Integer>();
        ArrayList<Integer> RMax = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i += 1) {
            if (i == 0) {
                LMin.add(A.get(i));
            } else {
                LMin.add(Math.min(LMin.get(i - 1), A.get(i)));
            }
            RMax.add(0);
        }
        for (int i = A.size() - 1; i >= 0; i -= 1) {
            if (i == A.size() - 1) {
                RMax.set(i, A.get(i));
            } else {
                RMax.set(i, Math.max(RMax.get(i + 1), A.get(i)));
            }
        }
        System.out.println(LMin.toString());
        System.out.println(RMax.toString());
        int i = 0, j = 0, best = -1;
        while (i < A.size() && j < A.size()) {
            if (LMin.get(i) <= RMax.get(j)) {
                best = Math.max(best, j - i);
                j += 1;
            } else {
                i += 1;
            }
        }
        return best;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 5, 4, 2));
        Solution sol = new Solution();
        System.out.println(sol.maximumGap(input));
    }
}