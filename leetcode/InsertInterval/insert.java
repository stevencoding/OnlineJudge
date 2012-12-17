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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> result = new ArrayList<Interval>();
        int len = intervals.size();
        if (len == 0) {
            result.add(newInterval);
        } else {
            if (newInterval.end < intervals.get(0).start) {
                result.add(newInterval);
                result.addAll(intervals);
                
            } else if (newInterval.start > intervals.get(len - 1).end) {
                result.addAll(intervals);
                result.add(newInterval);
            } else {
                int index = 0;
                while (index < len && !overlapTwo(intervals.get(index), newInterval) && intervals.get(index).end < newInterval.start) {
                    result.add(intervals.get(index++));
                }

                while (index < len && overlapTwo(intervals.get(index), newInterval)) {
                    newInterval = mergeTwo(intervals.get(index++), newInterval);
                }
                result.add(newInterval);
                while (index < len) {
                    result.add(intervals.get(index++));
                }
            }
        }
        return result;
        
    }
    private boolean overlapTwo(Interval a, Interval b) {
        return !((a.end < b.start) || (b.end < a.start));
    }
    private Interval mergeTwo(Interval a, Interval b) {
        return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
    }
}