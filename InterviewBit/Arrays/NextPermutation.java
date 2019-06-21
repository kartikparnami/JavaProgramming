/*
Question link: https://www.interviewbit.com/problems/next-permutation/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public void nextPermutation(ArrayList<Integer> a) {
        boolean didSwap = false;
        for (int i = a.size() - 2; i >= 0; i -= 1) {
            if (a.get(i) < a.get(i + 1)) {
                for (int j = i + 1; j <= a.size(); j += 1) {
                    if (j == a.size() || a.get(i) > a.get(j)) {
                        System.out.println(i + " " + j);
                        Collections.swap(a, i, j - 1);
                        Collections.sort(a.subList(i + 1, a.size()));
                        didSwap = true;
                        break;
                    }
                }
            }
            if (didSwap) {
                break;
            }
        }
        if (!didSwap) {
            Collections.sort(a);
        }
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 6, 5, 4));
        Solution sol = new Solution();
        sol.nextPermutation(input);
        System.out.println(input);
    }
}