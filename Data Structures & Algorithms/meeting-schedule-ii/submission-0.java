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
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Interval interval : intervals) {
            if(!pq.isEmpty() && pq.peek() <= interval.start) pq.poll();
            pq.offer(interval.end);
        }

        return pq.size();
    }
}
