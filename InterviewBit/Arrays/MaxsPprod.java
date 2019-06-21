/*
Question link: https://www.interviewbit.com/problems/maxspprod/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

class Solution {
    public int maxSpecialProduct(ArrayList<Integer> A) {
        Stack<Long> st = new Stack<>();
        Long[] next = new Long[A.size()];
        Arrays.fill(next, new Long(0));
        Long[] prev = new Long[A.size()];
        Arrays.fill(prev, new Long(0));
        st.push(new Long(A.size() - 1));
        for (long i = A.size() - 2; i >= 0; i -= 1) {
            Long num = new Long(A.get(new Long(i).intValue()));
            while (!st.empty() && num >= new Long(A.get(st.peek().intValue()))) {
                st.pop();
            }
            if (st.empty()) {
                next[new Long(i).intValue()] = new Long(0);
            } else {
                next[new Long(i).intValue()] = st.peek();
            }
            st.push(i);
        }
        for (int i = 0; i < A.size(); i += 1) {
            System.out.print(next[i] + " ");
        }
        System.out.println();
        st.clear();
        st.push(new Long(0));
        for (long i = 1; i < A.size(); i += 1) {
            Long num = new Long(A.get(new Long(i).intValue()));
            while (!st.empty() && num >= new Long(A.get(st.peek().intValue()))) {
                st.pop();
            }
            if (st.empty()) {
                prev[new Long(i).intValue()] = new Long(0);
            } else {
                prev[new Long(i).intValue()] = st.peek();
            }
            st.push(i);
        }
        for (int i = 0; i < A.size(); i += 1) {
            System.out.print(prev[i] + " ");
        }
        System.out.println();
        long maxSpecialProduct = 0;
        for (int i = 0; i < A.size() - 1; i += 1) {
            maxSpecialProduct = Math.max(next[i] * prev[i], maxSpecialProduct);
        }
        maxSpecialProduct = maxSpecialProduct % 1000000007;
        return new Long(maxSpecialProduct).intValue();
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1));
        Solution sol = new Solution();
        System.out.println(sol.maxSpecialProduct(input));
    }
}