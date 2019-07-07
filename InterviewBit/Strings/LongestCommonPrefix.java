/*
Question link: https://www.interviewbit.com/problems/longest-common-prefix/
 */

import java.util.*;

class Solution {
    public String longestCommonPrefix(ArrayList<String> A) {
        if (A.size() == 0) {
            return "";
        } else if (A.size() == 1) {
            return A.get(0);
        } else {
            int len = 0;
            for (int i = 0; i < A.get(0).length(); i += 1) {
                boolean noMoreMatch = false;
                for (int j = 1; j < A.size(); j += 1) {
                    if (A.get(j).length() <= i) {
                        noMoreMatch = true;
                        break;
                    }
                    if (A.get(0).charAt(i) != A.get(j).charAt(i)) {
                        noMoreMatch = true;
                        break;
                    }
                }
                if (noMoreMatch) {
                    break;
                } else {
                    len += 1;
                }
            }
            return A.get(0).substring(0, len);
        }
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<String> strs = new ArrayList<>(Arrays.asList("jwws", "uoiu", "chgh"));
        Solution sol = new Solution();
        System.out.println(sol.longestCommonPrefix(strs));
    }
}