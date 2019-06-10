/*
Question link: https://www.interviewbit.com/problems/wave-array/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> waveNonLex(ArrayList<Integer> A) {
        for (int i = 1; i < A.size(); i += 2) {
            if (A.get(i) > A.get(i - 1)) {
                Integer temp = A.get(i - 1);
                A.set(i - 1, A.get(i));
                A.set(i, temp);
            } else if (((i + 1) < A.size()) && (A.get(i) > A.get(i + 1))) {
                Integer temp = A.get(i + 1);
                A.set(i + 1, A.get(i));
                A.set(i, temp);
            }
        }
        return A;
    }

    public ArrayList<Integer> waveLex(ArrayList<Integer> A) {
        Collections.sort(A);
        for (int i = 0; i < A.size(); i += 2) {
            if ((i + 1) < A.size()) {
                Integer temp = A.get(i + 1);
                A.set(i + 1, A.get(i));
                A.set(i, temp);
            }
        }
        return A;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Solution sol = new Solution();
        System.out.println(sol.waveNonLex(input));
        System.out.println(sol.waveLex(input));
    }
}