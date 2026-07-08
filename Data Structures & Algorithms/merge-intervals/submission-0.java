class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] interval : intervals) {
            int s = interval[0];
            int e = interval[1];
            if(s <= end) {
                end = Math.max(e, end);
            }
            else {
                res.add(new int[]{start, end});
                start = s;
                end = e;
            }
        }
        // add the last interval
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]); 
    }
}
