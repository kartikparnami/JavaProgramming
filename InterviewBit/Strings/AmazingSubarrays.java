/*
Question link: https://www.interviewbit.com/problems/amazing-subarrays/
 */

import java.util.*;

class Solution {
    public int solve(String A) {
        ArrayList<Character> chars = new ArrayList<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        long total = 0;
        for (int i = 0; i < A.length(); i += 1) {
            if (chars.indexOf(A.charAt(i)) != -1) {
                total += A.length() - i;
                total = total % 10003;
            }
        }
        return (int)total;
    }
}

class Main {
    public static void main(String[] args) {
        String A = "ABEC";
        Solution sol = new Solution();
        System.out.println(sol.solve(A));
    }
}