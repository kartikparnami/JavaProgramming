/*
Question link: https://www.interviewbit.com/problems/median-of-array/
 */

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    double medianOfFour(int a, int b, int c, int d) {
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        int min = Math.min(a, Math.min(b, Math.min(c, d)));
        return (a + b + c + d - max - min) / 2.0;
    }

    double medianOfThree(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        if (max == a) {
            if (b == min) {
                return c;
            } else {
                return b;
            }
        } else if (b == max) {
            if (a == min) {
                return c;
            } else {
                return a;
            }
        } else {
            if (a == min) {
                return b;
            } else {
                return a;
            }
        }
    }

    double findMedianUtil(List<Integer> a, List<Integer> b) {
        if (a.size() == 0) {
            if (b.size() > 0) {
                if (b.size() % 2 == 1) {
                    return b.get(b.size() / 2);
                } else {
                    return (b.get(b.size() / 2) + b.get((b.size() / 2) - 1)) / 2.0;
                }
            } else {
                return -1;
            }
        } else if (a.size() == 1) {
            if (b.size() == 0) {
                return a.get(0);
            } else if (b.size() == 1) {
                return (a.get(0) + b.get(0)) / 2.0;
            } else if (b.size() == 2) {
                return medianOfThree(a.get(0), b.get(0), b.get(1));
            } else if (b.size() % 2 == 1) {
                int back = b.get((b.size() / 2) - 1);
                int mid = b.get(b.size() / 2);
                int forward = b.get((b.size() / 2) + 1);
                int curr = a.get(0);
                return (mid + medianOfThree(back, forward, curr)) / 2.0;
            } else {
                int back = b.get((b.size() / 2) - 1);
                int mid = b.get(b.size() / 2);
                int curr = a.get(0);
                System.out.println(back + " " + mid + " " + curr);
                return medianOfThree(back, mid, curr);
            }
        } else if (a.size() == 2) {
            if (b.size() == 0) {
                return (a.get(0) + a.get(1)) / 2.0;
            } else if (b.size() == 1) {
                return medianOfThree(a.get(0), a.get(1), b.get(0));
            } else if (b.size() == 2) {
                return medianOfFour(a.get(0), a.get(1), b.get(0), b.get(1));
            } else if ((b.size() % 2) == 1) {
                return medianOfThree(b.get(b.size() / 2), Math.max(a.get(0), b.get(b.size()/2 - 1)), Math.min(a.get(1), b.get(b.size()/2 + 1)));
            } else {
                return medianOfFour(b.get(b.size()/2), b.get(b.size()/2 - 1), Math.max(a.get(0), b.get(b.size()/2 - 2)), Math.min(a.get(1), b.get(b.size()/2 + 1)));
            }
        } else {
            int idxA = (a.size() - 1) / 2;
            int idxB = (b.size() - 1) / 2;
            if (a.get(idxA) <= b.get(idxB)) {
                return findMedianUtil(a.subList(idxA, a.size()), b.subList(0, b.size() - idxA));
            }
            return findMedianUtil(a.subList(0, a.size() - idxA), b.subList(idxA, b.size()));
        }
    }

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if (a.size() < b.size()) {
            return findMedianUtil(a, b);
        }
        return findMedianUtil(b, a);
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-31));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(-43, -35, -11, -6, -6, 22, 25, 49));
        Solution sol = new Solution();
        System.out.println(sol.findMedianSortedArrays(A, B));
    }
}