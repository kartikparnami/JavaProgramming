/*
Question link: https://www.interviewbit.com/problems/fizzbuzz/
 */

import java.util.*;

class Solution {
    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> fb = new ArrayList<>();
        for (int i = 1; i <= A; i += 1) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                fb.add("FizzBuzz");
            } else if (i % 3 == 0) {
                fb.add("Fizz");
            } else if (i % 5 == 0) {
                fb.add("Buzz");
            } else {
                fb.add((new Integer(i)).toString());
            }
        }
        return fb;
    }
}

class Main {
    public static void main(String[] args) {
        int A = 15;
        Solution sol = new Solution();
        System.out.println(sol.fizzBuzz(A));
    }
}