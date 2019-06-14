/*
Question link: https://www.interviewbit.com/problems/hotel-bookings-possible/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        int totalGuests = 0;
        Collections.sort(arrive);
        Collections.sort(depart);
        int i = 0, j = 0;
        while (i < arrive.size() && j < depart.size()) {
            if (arrive.get(i) < depart.get(j)) {
                totalGuests += 1;
                i += 1;
                if (totalGuests > K) {
                    return false;
                }
            } else {
                totalGuests -= 1;
                j += 1;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(18, 40));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(40, 43));
        Solution sol = new Solution();
        System.out.println(sol.hotel(arrive, depart, 1));
    }
}