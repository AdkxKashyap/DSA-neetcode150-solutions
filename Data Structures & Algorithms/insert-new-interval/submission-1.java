class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        int start = newInterval[0];
        int end = newInterval[1];
        while(i < n && intervals[i][1] < start) {
            res.add(intervals[i++]);
        }

        while(i < n && end >= intervals[i][0]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        res.add(new int[]{start, end});

        while(i < n) {
            res.add(intervals[i++]);
        }
        return res.toArray(new int[res.size()][]);
        
    }
}
