class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int rem = 0;
        int starts = 0;

        for(int i = 0; i < n; i++) {
            rem += gas[i] - cost[i];
            if(rem < 0) {
                starts = i + 1;
                rem = 0;
            }
        }

        for(int i = 0; i < starts; i++) {
            rem += gas[i] - cost[i];

            if(rem < 0) return -1;
        }
        return starts;
    }
}
