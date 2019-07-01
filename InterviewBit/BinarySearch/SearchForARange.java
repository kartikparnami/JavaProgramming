/*
Question link: https://www.interviewbit.com/problems/search-for-a-range/
 */

import java.util.*;

class Solution {
    int findStartCount(List<Integer> A, int start, int end, int B) {
        if (start > end) {
            return -1;
        }
        if (start < 0 || end < 0 || start >= A.size() || end >= A.size()) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (A.get(mid) == B) {
            if (mid == 0 || A.get(mid - 1) != B) {
                return mid;
            } else {
                return findStartCount(A, start, mid - 1, B);
            }
        } else if (A.get(mid) > B) {
            return findStartCount(A, start, mid - 1, B);
        } else {
            return findStartCount(A, mid + 1, end, B);
        }
    }

    int findEndCount(List<Integer> A, int start, int end, int B) {
        if (start > end) {
            return -1;
        }
        if (start < 0 || end < 0 || start >= A.size() || end >= A.size()) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (A.get(mid) == B) {
            if (mid == A.size() - 1 || A.get(mid + 1) != B) {
                return mid;
            } else {
                return findEndCount(A, mid + 1, end, B);
            }
        } else if (A.get(mid) > B) {
            return findEndCount(A, start, mid - 1, B);
        } else {
            return findEndCount(A, mid + 1, end, B);
        }
    }

    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        ArrayList<Integer> arr = new ArrayList<>();
        int startCount = findStartCount(A, 0, A.size() - 1, B);
        int endCount = findEndCount(A, startCount, A.size() - 1, B);
//        System.out.println(startCount + " " + endCount);
        if (startCount == -1 || endCount == -1) {
            arr.add(-1);
            arr.add(-1);
            return arr;
        } else {
            arr.add(startCount);
            arr.add(endCount);
            return arr;
        }
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 3, 3, 3, 4, 5 ,6));
        int B = 0;
        Solution sol = new Solution();
        System.out.println(sol.searchRange(arr, B));
    }
}