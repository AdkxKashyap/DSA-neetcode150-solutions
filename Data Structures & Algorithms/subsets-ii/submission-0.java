class Solution {
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        n = nums.length;
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int start, List<Integer> asf) {
        res.add(new ArrayList<>(asf));
        for(int i = start; i < n; i++) {
            if(i != start && nums[i] == nums[i-1]) continue;
            asf.add(nums[i]);
            helper(nums, i + 1, asf);
            asf.remove(asf.size() - 1);
        }

    }
}
