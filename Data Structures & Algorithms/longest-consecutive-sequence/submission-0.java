class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int max = 1;
        for(int num : nums) {
            set.add(num);
        }
        for(int num : set) {
            int count = 1;
            int val = num;
            if(!set.contains(val - 1)) {
                while(set.contains(val + 1)) {
                    count++;
                    val += 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
