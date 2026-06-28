class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //build fmap
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for(int num : nums) {
            fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        }
        //create buckets
        int n = nums.length;
        List<Integer>[] buckets = new ArrayList[n+1];
        for(int key : fmap.keySet()) {
            int freq = fmap.get(key);
            if(buckets[freq] == null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }
        //get top k. Traverse buckets from end;
        int[] res = new int[k];
        int idx = 0;
        for(int i = n; i >= 0; i--) {
            if(buckets[i] != null) {
                for(int num : buckets[i]) {
                    res[idx++] = num;
                    if(idx == k) return res;
                }
            }  
        }
        return res;
    }
}
