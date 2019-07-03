/*
Question link: https://www.interviewbit.com/problems/allocate-books/
 */

import java.util.*;

class Solution {
    boolean isSolutionFeasible(ArrayList<Integer> A, int M, int maxSum) {
//        System.out.println(maxSum);
        int students = 0;
        int currSum = 0;
        for (int i = 0; i < A.size(); i += 1) {
            if (A.get(i) > maxSum) {
                return false;
            }
            if (currSum == 0) {
                currSum += A.get(i);
                students += 1;
            } else if (currSum + A.get(i) > maxSum) {
                currSum = A.get(i);
                students += 1;
                if (students > M) {
                    return false;
                }
            } else {
                currSum += A.get(i);
            }
        }
        return true;
    }

    public int books(ArrayList<Integer> A, int B) {
        if (A.size() < B) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < A.size(); i += 1) {
            sum += A.get(i);
        }
        int start = 0, end = sum;
        int result = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
//            System.out.println(start + " " + mid + " " + end + " " + isSolutionFeasible(A, B, mid));
            if (isSolutionFeasible(A, B, mid)) {
                result = Math.min(result, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24));
        int B = 26;
        Solution sol = new Solution();
        System.out.println(sol.books(A, B));
    }
}