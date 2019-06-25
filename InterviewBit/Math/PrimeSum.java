/*
Question link: https://www.interviewbit.com/problems/prime-sum/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

class Solution {
    public boolean isPrime(int n) {
        if (n > 2 && n %2 == 0){
            return false;
        }
        int top = (int)Math.sqrt(n)+1;
        for (int i=3;i<top;i+=2){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> primesum(int A) {
        if (isPrime(A - 2)) {
            return new ArrayList<Integer>(Arrays.asList(2, A - 2));
        } else {
            for (int i = 3; i <= A/2; i += 2) {
                if (isPrime(A - i) && isPrime(i)) {
                    return new ArrayList<Integer>(Arrays.asList(i, A - i));
                }
            }
        }
        return new ArrayList<Integer>();
    }
}

class Main {
    public static void main(String[] args) {
        int A = 4;
        Solution sol = new Solution();
        System.out.println(sol.primesum(A));
    }
}