/*
Question link: https://www.interviewbit.com/problems/largest-number/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public String largestNumber(final ArrayList<Integer> A) {
        ArrayList<String> B = new ArrayList<>();
        for (int i = 0; i < A.size(); i += 1) {
            B.add(A.get(i).toString());
        }
//        System.out.println(B);
        Collections.sort(B, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o11 = o1 + o2;
                String o22 = o2 + o1;
                return o22.compareTo(o11);
            }
        });
//        System.out.println(B);
        StringBuilder sol = new StringBuilder();
        for (int i = 0; i < B.size(); i += 1) {
            sol.append(B.get(i));
        }
//        System.out.println(sol);
//        return "";
        int leadingZeros = 0;
        char zero = "0".charAt(0);
        for (int i = 0; i < sol.length() - 1; i += 1) {
            char s = sol.charAt(i);
            if (s == zero) {
                leadingZeros += 1;
            } else {
                break;
            }
        }
        return sol.substring(leadingZeros);
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
        Solution sol = new Solution();
        System.out.println(sol.largestNumber(input));
    }
}