/*
Question link: https://www.interviewbit.com/problems/grid-unique-paths/
 */

import java.util.*;

class Solution {
    public int uniquePaths(int A, int B) {
        int[][] arr = new int [A][B];
        for (int i = 0; i < A; i += 1) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < B; i += 1) {
            arr[0][i] = 1;
        }
        for (int i = 1; i < A; i += 1) {
            for (int j = 1; j < B; j += 1) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[A - 1][B - 1];
    }
}

class Main {
    public static void main(String[] args) {
        int A = 4, B = 4;
        Solution sol = new Solution();
        System.out.println(sol.uniquePaths(A, B));
    }
}