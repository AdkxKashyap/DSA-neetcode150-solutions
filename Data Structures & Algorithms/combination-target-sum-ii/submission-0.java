class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();

        helper(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] cands, int tar, int start, List<Integer> asf) {
        if(tar == 0) {
            res.add(new ArrayList<>(asf));
            return;
        }
        if(tar < 0 || start >= cands.length) return;

        for(int i = start; i < cands.length; i++) {
            if(i != start && cands[i] == cands[i-1]) continue;
            asf.add(cands[i]);
            helper(cands, tar - cands[i], i+1, asf);
            asf.remove(asf.size() - 1);
        }
    }
}
