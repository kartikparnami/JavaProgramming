/*
Question link: https://www.interviewbit.com/problems/matrix-median/
 */

import java.io.IOException;
import java.util.*;

class Solution {
    public int findMedian(ArrayList<ArrayList<Integer>> A) throws IOException {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int n = A.size(), m = A.get(0).size();
        int desired = (n * m + 1) / 2;
        for (int i = 0; i < n; i += 1) {
            min = Math.min(min, A.get(i).get(0));
        }
        for (int i = 0; i < n; i += 1) {
            max = Math.max(max, A.get(i).get(m - 1));
        }
        System.out.println(min + " " + max + " " + desired);
        while (min < max) {
            int place = 0;
            int mid = min + (max - min)/2;
            for (int i = 0; i < n; i += 1) {
                int get = 0;
                int pos = Arrays.binarySearch(A.get(i).toArray(), mid);
                if (pos >= 0) {
                    while (pos < A.get(i).size() && A.get(i).get(pos) == mid) {
                        pos += 1;
                    }
                    get = pos;
                } else {
                    get = Math.abs(pos) - 1;
                }
                System.out.println(get);
                place += get;
            }
            System.out.println(place);
            if (place < desired)
                min = mid + 1;
            else
                max = mid;
            System.out.println(min + " " + max);
        }
        return min;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 3, 3)));
//        A.add(new ArrayList<Integer>(Arrays.asList(2, 6, 9)));
//        A.add(new ArrayList<Integer>(Arrays.asList(3, 6, 9)));
        Solution sol = new Solution();
        System.out.println(sol.findMedian(A));
    }
}
