/*
Question link: https://www.interviewbit.com/problems/rotated-sorted-array-search/
 */

import java.util.*;

class Solution {
    public int search(final List<Integer> a, int b) {
        int start = 0, end = a.size() - 1, pivot = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
//            System.out.println(start + " " + mid + " " + end);
            if (mid != 0 && a.get(mid) < a.get(mid - 1)) {
                pivot = mid;
                break;
            } else if (mid == 0) {
                pivot = mid;
                break;
            } else {
                if (a.get(mid) > a.get(0)) {
                    if (a.get(mid) > a.get(a.size() - 1)) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (a.get(mid) < a.get(a.size() - 1)) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }
//        System.out.println(pivot);
        if (b <= a.get(a.size() - 1)) {
            int pos = Collections.binarySearch(a.subList(pivot, a.size()), b);
            if (pos >= 0) {
                return pos + pivot;
            }
        } else {
//            System.out.println(a.subList(0, pivot));
            int pos = Collections.binarySearch(a.subList(0, pivot), b);
            if (pos >= 0) {
                return pos;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        int B = 6;
        Solution sol = new Solution();
        System.out.println(sol.search(A, B));
    }
}