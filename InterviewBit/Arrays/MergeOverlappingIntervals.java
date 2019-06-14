/*
Question link: https://www.interviewbit.com/problems/merge-overlapping-intervals/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }

class Solution {

    public Comparator<Interval> comp = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    };

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, comp);
        ArrayList<Boolean> shouldRemain = new ArrayList<>();
        ArrayList<Interval> sol = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i += 1) {
            shouldRemain.add(true);
        }
        int count = 0;
        while (count < intervals.size()) {
            int innerCount = count + 1;
            while (innerCount < intervals.size()) {
                if (intervals.get(innerCount).start <= intervals.get(count).end) {
                    intervals.get(count).end = Math.max(intervals.get(count).end, intervals.get(innerCount).end);
                    shouldRemain.set(innerCount, false);
                    innerCount += 1;
                } else {
                    break;
                }
            }
            count = innerCount;
        }
        for (int i = 0; i < shouldRemain.size(); i += 1) {
            if (shouldRemain.get(i)) {
                sol.add(intervals.get(i));
            }
        }
        return sol;
    }

}

class Main {
    public static void main(String[] args) {
        ArrayList<Interval> input = new ArrayList<>(Arrays.asList(
                new Interval(15, 18),
                new Interval(1, 3),
                new Interval(2, 12),
                new Interval(8, 17)
        ));
        Solution sol = new Solution();
        ArrayList<Interval> solved = sol.merge(input);
        for (Interval i: solved) {
            System.out.println(String.format("%d %d", i.start, i.end));
        }
    }
}