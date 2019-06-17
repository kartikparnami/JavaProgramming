/*
Question link: https://www.interviewbit.com/problems/rotate-matrix/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int upRow = 0, rightCol = a.get(0).size() - 1, downRow = a.size() - 1, leftCol = 0;
        while (upRow < downRow) {
            int i = 0;
            while (i < (rightCol - leftCol)) {
                int firstY = upRow, firstX = i + leftCol;
                int secondY = upRow + i, secondX = rightCol;
                int thirdY = downRow, thirdX = rightCol - i;
                int fourthY = downRow - i, fourthX = leftCol;
                int temp = a.get(fourthY).get(fourthX);
                a.get(fourthY).set(fourthX, a.get(thirdY).get(thirdX));
                a.get(thirdY).set(thirdX, a.get(secondY).get(secondX));
                a.get(secondY).set(secondX, a.get(firstY).get(firstX));
                a.get(firstY).set(firstX, temp);
                i += 1;
            }
            upRow += 1;
            downRow -= 1;
            leftCol += 1;
            rightCol -= 1;
        }
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        Solution sol = new Solution();
        System.out.println(sol.rotate(input));
    }
}