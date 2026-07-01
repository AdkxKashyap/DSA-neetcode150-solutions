class Solution {
    Set<Integer> set;
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> permute(int[] nums) {
        set = new HashSet<>();
        res = new ArrayList<>();
        n = nums.length;
        helper(nums, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, List<Integer> asf) {
        if(asf.size() == n) {
            res.add(new ArrayList<>(asf));
            return;
        }

        for(int num : nums) {
            if(!set.contains(num)) {
                asf.add(num);
                set.add(num);
                helper(nums, asf);
                asf.remove(asf.size() - 1);
                set.remove(num);
            }   
        }
    }
}
