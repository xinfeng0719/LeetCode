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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        boolean added=false;
        for(Interval prev:intervals){
            if(prev.start>newInterval.end){
                if(!added) result.add(newInterval);
                result.add(prev);
                added=true;
            }else if(prev.end<newInterval.start){
                result.add(prev);
            }else{
                int newStart = Math.min(prev.start,newInterval.start);
                int newEnd = Math.max(prev.end,newInterval.end);
                newInterval = new Interval(newStart,newEnd);
            }
        }
        if(!added) result.add(newInterval);
        return result;
    }
}
