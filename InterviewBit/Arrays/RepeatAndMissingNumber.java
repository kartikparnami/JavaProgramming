/*
Question link: https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 */

import java.util.*;

class Solution {
    public ArrayList<Integer> repeatedNumberXor(final List<Integer> A) {
        Integer a = 0, b = 0, aXorB = 0, aXorBCopy = 0;

        for (int i = 0; i < A.size(); i += 1) {
            aXorB = aXorB ^ A.get(i) ^ (i + 1);
        }

        aXorBCopy = aXorB;

        Integer rightMostBit = aXorBCopy ^ (aXorBCopy - 1), setBit = 0;
        while (rightMostBit != 1) {
            aXorBCopy = aXorBCopy >> 1;
            setBit += 1;
            rightMostBit = aXorBCopy ^ (aXorBCopy - 1);
        }

        Integer mask = 1;
        while (setBit > 0) {
            mask = mask << 1;
            setBit -= 1;
        }

        for (int i = 0; i < A.size(); i += 1) {
            if ((mask & A.get(i)) == 0) {
                a = a ^ A.get(i);
            } else {
                b = b ^ A.get(i);
            }
        }

        for (int i = 1; i <= A.size(); i += 1) {
            if ((mask & i) == 0) {
                a = a ^ i;
            } else {
                b = b ^ i;
            }
        }

        ArrayList<Integer> solution = new ArrayList<>();
        for (int i = 0; i < A.size(); i += 1) {
            if (A.get(i).equals(a)) {
                solution.add(a);
                solution.add(b);
                break;
            } else if (A.get(i).equals(b)) {
                solution.add(b);
                solution.add(a);
                break;
            }
        }

        return solution;
    }

    public ArrayList<Integer> repeatedNumberCounter(final List<Integer> A) {
        Integer a = -1, b = -1;
        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int i = 0; i < A.size(); i += 1) {
            if (counter.containsKey(A.get(i))) {
                a = A.get(i);
            } else {
                counter.put(A.get(i), 1);
            }
        }

        for (int i = 0; i < A.size(); i += 1) {
            if (!counter.containsKey(i + 1)) {
                b = i + 1;
            }
        }
        return new ArrayList<Integer>(Arrays.asList(a, b));
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc  = new Scanner(System.in);

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3));
        System.out.println(sol.repeatedNumberCounter(A));
        System.out.println(sol.repeatedNumberXor(A));
    }
}