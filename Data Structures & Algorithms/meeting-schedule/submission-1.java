/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        Interval prevMeet = new Interval(-1, -1);
        for(Interval currMeet : intervals) {
            if(prevMeet.end > currMeet.start) return false;
            prevMeet = currMeet; 
        }
        return true;
    }
}
