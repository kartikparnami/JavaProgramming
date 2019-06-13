/*
Question link: https://www.interviewbit.com/problems/max-non-negative-subarray/
 */

import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    private void copyArrayList(ArrayList<Integer> from, ArrayList<Integer> to) {
        to.clear();
        for (int i = 0; i < from.size(); i += 1) {
            to.add(from.get(i));
        }
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        long maxSoFar = 0, sumTillNow = 0, maxLenTillNow = -1;
        A.add(-1);
        ArrayList<Integer> sol = new ArrayList<Integer>();
        ArrayList<Integer> currList = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i += 1) {
            if (A.get(i) < 0) {
                if (sumTillNow > maxSoFar) {
                    copyArrayList(currList, sol);
                    maxSoFar = sumTillNow;
                    maxLenTillNow = currList.size();
                } else if ((sumTillNow == maxSoFar) && (currList.size() > maxLenTillNow)) {
                    copyArrayList(currList, sol);
                    maxLenTillNow = currList.size();
                }
                sumTillNow = 0;
                currList.clear();
            } else {
                sumTillNow += A.get(i);
                currList.add(A.get(i));
            }
        }
        return sol;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368));
        Solution sol = new Solution();
        System.out.println(sol.maxset(input));
    }
}