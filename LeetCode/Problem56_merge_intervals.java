/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        java.util.Collections.sort(intervals, new IntComp());
        int i = 1;
        while (i < intervals.size()) {
            Interval int1 = intervals.get(i - 1), int2 = intervals.get(i);
            if (isOverlap(int1, int2)) {
                int1.start = Math.min(int1.start, int2.start);
                int1.end = Math.max(int1.end, int2.end);
                intervals.remove(i);
            } else i++;
        }

        return intervals;
    }

    private boolean isOverlap(Interval a, Interval b) {
        return a.end >= b.start;
    }

    static class IntComp implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}