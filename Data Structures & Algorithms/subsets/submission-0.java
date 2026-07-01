class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int idx, List<Integer> asf) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(asf));
            return;
        }
        helper(nums, idx+1, asf);

        asf.add(nums[idx]);
        helper(nums, idx + 1, asf);
        asf.remove(asf.size() - 1);
    }
}
