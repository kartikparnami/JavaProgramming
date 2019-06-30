/*
Question link: https://www.interviewbit.com/problems/prettyprint/
 */

import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        int B = ((A - 1) * 2) + 1;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < B; i += 1) {
            arr.add(new ArrayList<Integer>(Collections.nCopies(B, 0)));
        }
        int top = 0, right = B - 1, bottom = B - 1, left = 0, currVal = A;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i += 1) {
//                System.out.println(top + " " + i);
                arr.get(top).set(i, currVal);
            }
            for (int i = top + 1; i <= bottom; i += 1) {
//                System.out.println(i + " " + right);
                arr.get(i).set(right, currVal);
            }
            for (int i = right - 1; i >= left; i -= 1) {
//                System.out.println(bottom + " " + i);
                arr.get(bottom).set(i, currVal);
            }
            for (int i = bottom - 1; i >= top + 1; i -= 1) {
//                System.out.println(i + " " + left);
                arr.get(i).set(left, currVal);
            }
            left += 1;
            top += 1;
            right -= 1;
            bottom -= 1;
            currVal -= 1;
        }
        return arr;
    }
}

class Main {
    public static void main(String[] args) {
        int A = 3;
        Solution sol = new Solution();
        System.out.println(sol.prettyPrint(A));
    }
}