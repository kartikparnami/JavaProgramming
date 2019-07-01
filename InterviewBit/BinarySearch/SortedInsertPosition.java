/*
Question link: https://www.interviewbit.com/problems/sorted-insert-position/
 */

import java.util.*;

class Solution {
    public int searchInsert(ArrayList<Integer> a, int b) {
        int start = 0, end = a.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println(start + " " + end + " " + mid);
            if (a.get(mid) == b) {
                return mid;
            } else {
                if (a.get(mid) > b) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return start;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 1, 2));
        int B = 3;
        Solution sol = new Solution();
        System.out.println(sol.searchInsert(A, B));
    }
}