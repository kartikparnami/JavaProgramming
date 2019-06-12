import java.util.ArrayList;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int startIndex = -1, endIndex = -1;
        if (newInterval.start > newInterval.end) {
            int temp = newInterval.end;
            newInterval.end = newInterval.start;
            newInterval.start = temp;
        }
        ArrayList<Boolean> shouldKeep = new ArrayList<>();
        ArrayList<Interval> finalList = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i += 1) {
            shouldKeep.add(true);
            if (intervals.get(i).start <= newInterval.start && intervals.get(i).end >= newInterval.start) {
                startIndex = i;
            }
            if (intervals.get(i).start <= newInterval.end && intervals.get(i).end >= newInterval.end) {
                endIndex = i;
            }
        }
        if (intervals.size() > 0) {
            if (startIndex != -1 && endIndex != -1) {
                Interval inte = new Interval(intervals.get(startIndex).start, intervals.get(endIndex).end);
                intervals.set(startIndex, inte);
                for (int i = startIndex + 1; i <= endIndex; i += 1) {
                    shouldKeep.set(i, false);
                }
            } else if (startIndex != -1 && endIndex == -1) {
                Interval inte = new Interval(intervals.get(startIndex).start, newInterval.end);
                intervals.set(startIndex, inte);
                for (int i = startIndex + 1; i < intervals.size(); i += 1) {
                    if (intervals.get(i).start < newInterval.end) {
                        shouldKeep.set(i, false);
                    }
                }
            } else if (startIndex == -1 && endIndex != -1) {
                Interval inte = new Interval(newInterval.start, intervals.get(endIndex).end);
                intervals.set(endIndex, inte);
                for (int i = 0; i < endIndex; i += 1) {
                    if (intervals.get(i).start > newInterval.start) {
                        shouldKeep.set(i, false);
                    }
                }
            } else if (intervals.get(0).start > newInterval.start && intervals.get(intervals.size() - 1).end < newInterval.end) {
                intervals.set(0, newInterval);
                for (int i = 1; i < intervals.size(); i += 1) {
                    shouldKeep.set(i, false);
                }
            } else {
                boolean added = false;
                for (int i = 0; i < intervals.size(); i += 1) {
                    if (intervals.get(i).start > newInterval.start && intervals.get(i).end < newInterval.end {
                        shouldKeep.set(i, false);
                    }
                    if (intervals.get(i).start > newInterval.start && intervals.get(i).end > newInterval.end) {
                        intervals.add(i, newInterval);
                        shouldKeep.add(i, true);
                        added = true;
                        break;
                    }
                }
                if (!added) {
                    intervals.add(newInterval);
                    shouldKeep.add(true);
                }
            }
            for (int i = 0; i < intervals.size(); i += 1) {
                if (shouldKeep.get(i)) {
                    finalList.add(intervals.get(i));
                }
            }
        } else {
            finalList.add(newInterval);
        }
        return finalList;
    }
}

class Main {
    public static void main(String[] args) {

    }
}