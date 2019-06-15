/*
Question link: https://www.interviewbit.com/problems/maximum-unsorted-subarray/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> sol = new ArrayList<>();
        int leftSort = -1;
        for (int i = 1; i < A.size(); i += 1) {
            if (A.get(i) < A.get(i - 1)) {
                leftSort = i - 1;
                break;
            }
        }
        int rightSort = -1;
        for (int j = A.size() - 2; j >= 0; j -= 1) {
            if (A.get(j) > A.get(j + 1)) {
                rightSort = j + 1;
                break;
            }
        }
        System.out.println(leftSort);
        System.out.println(rightSort);
        if (leftSort == -1 || rightSort == -1) {
           sol.add(-1);
        } else {
            int mini = 999999999, maxi = -999999999;
            for (int i = leftSort; i <= rightSort; i += 1) {
                mini = Math.min(mini, A.get(i));
                maxi = Math.max(maxi, A.get(i));
            }
            int i = leftSort - 1;
            while (i >= 0) {
                if (A.get(i) <= mini) {
                    break;
                } else {
                    leftSort = i;
                    i -= 1;
                }
            }
            int j = rightSort + 1;
            while (j < A.size()) {
                if (A.get(j) >= maxi) {
                    break;
                } else {
                    rightSort = j;
                    j += 1;
                }
            }
            sol.add(leftSort);
            sol.add(rightSort);
        }
        return sol;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 3, 4, 5, 5, 9, 11, 13, 14, 15, 15, 16, 15, 20, 16));
        Solution sol = new Solution();
        System.out.println(sol.subUnsort(input));
    }
}