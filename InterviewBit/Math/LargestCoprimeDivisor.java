/*
Question link: https://www.interviewbit.com/problems/largest-coprime-divisor/
 */

import java.util.*;

class Solution {
    public HashMap<Integer, Integer> getPrimeFactors(int A) {
        HashMap<Integer, Integer> primeFactors = new HashMap<>();
        if (A == 1) {
            return primeFactors;
        }
        int count = 0;
        while (A % 2 == 0) {
            A /= 2;
            count += 1;
        }
        if (count > 0) {
            primeFactors.put(2, count);
        }
        for (int i = 3; i <= Math.sqrt(A); i += 2) {
            int newCount = 0;
            while (A % i == 0) {
                A /= i;
                newCount += 1;
            }
            if (newCount > 0) {
                primeFactors.put(i, newCount);
            }
        }
        if (A > 2) {
            primeFactors.put(A, 1);
        }
        return primeFactors;
    }

    public int cpFact(int A, int B) {
        int X = 1;
        HashMap<Integer, Integer> primeA = getPrimeFactors(A);
        HashMap<Integer, Integer> primeB = getPrimeFactors(B);
        for (int key: primeA.keySet()) {
            if (!primeB.containsKey(key)) {
                for (int i = 0; i < primeA.get(key); i += 1) {
                    X = X * key;
                }
            }
        }
        return X;
    }
}

class Main {
    public static void main(String[] args) {
        int A = 30;
        int B = 12;
        Solution sol = new Solution();
        System.out.println(sol.cpFact(A, B));
    }
}