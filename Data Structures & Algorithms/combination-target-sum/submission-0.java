class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        helper(nums, 0, target, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int start, int tar, List<Integer> tmp) {
        if(tar == 0) {
            res.add(new ArrayList<>(tmp));
        }
        if(tar < 0) return;

        for(int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            helper(nums, i, tar - nums[i], tmp);
            tmp.remove(tmp.size() - 1);
        }

    }
}
