/*
Question link: https://www.interviewbit.com/problems/n3-repeat-number/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int repeatedNumber(final List<Integer> a) {
        int count1 = 0, count2 = 0, first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i = 0; i < a.size(); i += 1) {
            if (a.get(i) == first) {
                count1 += 1;
            } else if (a.get(i) == second) {
                count2 += 1;
            } else if (count1 == 0) {
                count1 += 1;
                first = a.get(i);
            } else if (count2 == 0) {
                count2 += 1;
                second = a.get(i);
            } else {
                count1 -= 1;
                count2 -= 1;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < a.size(); i += 1) {
            if (a.get(i) == first) {
                count1 += 1;
            }
            if (a.get(i) == second) {
                count2 += 1;
            }
        }
        if (count1 > a.size()/3) {
            return first;
        } else if (count2 > a.size()/3) {
            return second;
        } else {
            return -1;
        }
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 2, 4));
        Solution sol = new Solution();
        System.out.println(sol.repeatedNumber(input));
    }
}