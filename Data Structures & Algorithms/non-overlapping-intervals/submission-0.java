class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int end = Integer.MIN_VALUE;
        int count = 0;
        for(int[] interval : intervals) {
            int intStart = interval[0];
            int intEnd = interval[1];
            if(intStart < end) {
                count++;
                end = Math.min(end, intEnd);
            } else {
                end = intEnd;
            }
        }
        return count;
    }
}