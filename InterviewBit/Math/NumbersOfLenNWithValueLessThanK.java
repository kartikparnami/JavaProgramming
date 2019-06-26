/*
Question link: https://www.interviewbit.com/problems/numbers-of-length-n-and-value-less-than-k/
 */

import java.util.*;

class Solution {
    public int solve(ArrayList<Integer> A, int B, int C) {
        if (A.size() == 0) {
            return 0;
        }
        boolean hasZero = false;
        if (A.get(0) == 0) {
            hasZero = true;
        }
        if (String.valueOf(C).length() > B) {
            int total = 1;
            for (int i = 0; i < B; i += 1) {
                if (i == 0 && B > 1 && hasZero) {
                    total = total * (A.size() - 1);
                } else {
                    total = total * (A.size());
                }
            }
            return total;
        } else if (String.valueOf(C).length() < B) {
            return 0;
        } else {
            int total = 0;
            String CStr = String.valueOf(C);
            for (int i = 0; i < CStr.length(); i += 1) {
                boolean stopAfter = false;
                int numInQ = Character.getNumericValue(CStr.charAt(i));
                int diff = A.indexOf(numInQ);
                while (diff < 0) {
                    if (numInQ > A.get(A.size() - 1)) {
                        diff = A.size();
                        stopAfter = true;
                        break;
                    } else {
                        numInQ += 1;
                        diff = A.indexOf(numInQ);
                        stopAfter = true;
                    }
                }
                System.out.println(CStr.charAt(i) + " " + diff);
                if (i == 0 && B > 1 && hasZero) {
                    diff -= 1;
                }
                System.out.println(CStr.charAt(i) + " " + diff);
                int multiple = 1;
                for (int j = 1; j < B - i; j += 1) {
                    multiple *= (A.size());
                }
                int more = diff * multiple;
                System.out.println(multiple + " " + more);
                total += more;
                System.out.println("-=-=-=-=");
                if (stopAfter) {
                    break;
                }
            }
            return total;
        }
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0));
        int B = 1;
        int C = 5;
        Solution sol = new Solution();
        System.out.println(sol.solve(A, B, C));
    }
}