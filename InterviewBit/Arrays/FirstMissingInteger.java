/*
Question link: https://www.interviewbit.com/problems/first-missing-integer/

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // n : size of array
            int n = Integer.parseInt(br.readLine());

            // Declaring array
            int arr[] = new int[n];

            // to read multiple integers line
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
        }
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int ans = A.size() + 1;
        for (int i = 0; i < A.size(); i += 1) {
            if (A.get(i) < 1) {
                A.set(i, 0);
            }
        }
        System.out.println(A);
        for (int i = 0; i < A.size(); i += 1) {
            if (Math.abs(A.get(i)) >= 1 && Math.abs(A.get(i)) <= A.size()) {
                int index = Math.abs(A.get(i)) - 1;
                if (A.get(index) > 0) {
                    A.set(index, -1 * (A.get(index)));
                } else if (A.get(index) == 0) {
                    A.set(index, -1 * (A.size() + 3));
                }
            }
        }
        System.out.println(A);
        for (int i = 0; i < A.size(); i += 1) {
            if (A.get(i) >= 0) {
                ans = i + 1;
                break;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(-47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36, 44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21, -19, -33, 47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21, -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43, -50, -16, 14, -26));
        Solution sol = new Solution();
        System.out.println(sol.firstMissingPositive(input));
    }
}