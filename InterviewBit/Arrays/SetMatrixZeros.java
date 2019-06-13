/*
Question link: https://www.interviewbit.com/problems/set-matrix-zeros/
 */

import java.util.ArrayList;

class Solution {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        ArrayList<Boolean> cols = new ArrayList<>();
        ArrayList<Boolean> rows = new ArrayList<>();
        for (int i = 0; i < a.size(); i += 1) {
            rows.add(false);
        }
        for (int i = 0; i < a.get(0).size(); i += 1) {
            cols.add(false);
        }
        for (int i = 0; i < a.size(); i += 1) {
            for (int j = 0; j < a.get(0).size(); j += 1) {
                if (a.get(i).get(j) == 0) {
                    cols.set(j, true);
                    rows.set(i, true);
                }
            }
        }
        for (int i = 0; i < a.size(); i += 1) {
            for (int j = 0; j < a.get(0).size(); j += 1) {
                if (rows.get(i) || cols.get(j)) {
                    a.get(i).set(j, 0);
                }
            }
        }
    }

}

class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        Solution sol = new Solution();
        sol.setZeroes(input);
    }
}