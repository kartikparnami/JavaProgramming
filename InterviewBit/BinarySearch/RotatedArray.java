/*
Question link: https://www.interviewbit.com/problems/rotated-array/
 */

import java.util.*;

class Solution {
    int findMinRecur(List<Integer> a, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start < 0 || end < 0 || start >= a.size() || end >= a.size()) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (mid == 0) {
            return mid;
        } else if (a.get(mid) < a.get(mid - 1)) {
            return mid;
        } else if (a.get(mid) > a.get(0)) {
            return findMinRecur(a, mid + 1, end);
        } else {
            return findMinRecur(a, start, mid - 1);
        }
    }

    public int findMin(final List<Integer> a) {
        if (a.get(0) < a.get(a.size() - 1)) {
            return a.get(0);
        }
        int min = findMinRecur(a, 0, a.size() - 1);
        if (min != -1) {
            return a.get(min);
        } else {
            return -1;
        }
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 1));
        Solution sol = new Solution();
        System.out.println(sol.findMin(a));
    }
}