/*
Question link: https://www.interviewbit.com/problems/spiral-order-matrix-ii/
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        int leftCol = 0, rightCol = A - 1, topRow = 0, bottomRow = A - 1;
        for (int i = 0; i < A; i += 1) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j < A; j += 1) {
                a.add(0);
            }
            B.add(a);
        }
        int currNum = 1;
        while (leftCol <= rightCol && topRow <= bottomRow) {
            for (int i = leftCol; i <= rightCol; i += 1) {
                B.get(topRow).set(i, currNum);
                currNum += 1;
            }
            for (int i = topRow + 1; i <= bottomRow; i += 1) {
                B.get(i).set(rightCol, currNum);
                currNum += 1;
            }
            for (int i = rightCol - 1; i >= leftCol; i -= 1) {
                B.get(bottomRow).set(i, currNum);
                currNum += 1;
            }
            for (int i = bottomRow - 1; i > topRow; i -= 1) {
                B.get(i).set(leftCol, currNum);
                currNum += 1;
            }
            leftCol += 1;
            rightCol -= 1;
            topRow += 1;
            bottomRow -= 1;
        }
        return B;
    }
}

class Main {
    public static void main(String[] args) {
        int n = 5;
        Solution sol = new Solution();
        System.out.println(sol.generateMatrix(n));
    }
}