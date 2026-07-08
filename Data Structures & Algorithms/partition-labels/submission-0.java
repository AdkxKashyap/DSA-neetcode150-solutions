class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res= new ArrayList<>();
        int slen = s.length();
        if(slen == 0) return res;
        int[] lastSeenMap = new int[26];
        for(int i = 0; i < slen; i++) {
            lastSeenMap[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < slen; i++) {
            end = Math.max(end, lastSeenMap[s.charAt(i) - 'a']);
            if(i == end) {
                res.add(end - start + 1);
                start = i + 1;
                end = i + 1;
            }
        }
        return res;
    }
}