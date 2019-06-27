/*
Question link: https://www.interviewbit.com/problems/rearrange-array/
 */

import java.util.*;

class Solution {
    public void arrange(ArrayList<Integer> a) {
        int n = a.size();
        for (int i = 0; i < a.size(); i += 1) {
            int A = a.get(i);
            int B = (a.get(A) % n) * n;
            a.set(i, A + B);
        }
        for (int i = 0; i < a.size(); i += 1) {
            a.set(i, a.get(i)/n);
        }
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4, 0, 2, 1, 3));
        Solution sol = new Solution();
        sol.arrange(A);
//        System.out.println();
    }
}