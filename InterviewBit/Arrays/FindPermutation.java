/*
Question link: https://www.interviewbit.com/problems/find-permutation/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

class Solution {
    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        for (int i = 0; i < B; i += 1) {
            arrL.add(-1);
        }
        boolean[] arrBool = new boolean[B + 1];
        Arrays.fill(arrBool, false);
        int decrements = 0;
        for (int i = 0; i < A.length(); i += 1) {
            if (A.charAt(i) == 'D') {
                decrements += 1;
            }
        }
        int currIndex = B - 1;
        arrL.set(currIndex, B - decrements);
        arrBool[B - decrements] = true;
        currIndex -= 1;
        Stack<Integer> smallSt = new Stack<>();
        Stack<Integer> greaterSt = new Stack<>();
        for (int i = 1; i < B - decrements; i += 1) {
            smallSt.push(i);
        }
        for (int i = B; i >= B - decrements + 1; i -= 1) {
            greaterSt.push(i);
        }
        for (int i = A.length() - 1; i >= 0; i -= 1) {
            if (A.charAt(i) == 'D') {
                arrL.set(currIndex, greaterSt.peek());
                arrBool[greaterSt.peek()] = true;
                greaterSt.pop();
            } else {
                arrL.set(currIndex, smallSt.peek());
                arrBool[smallSt.peek()] = true;
                smallSt.pop();
            }
            currIndex -= 1;
        }
        return arrL;
    }
}

class Main {
    public static void main(String[] args) {
        String inputStr = new String("DIDIDIDI");
        int inputInt = 9;
        Solution sol = new Solution();
        System.out.println(sol.findPerm(inputStr, inputInt));
    }
}