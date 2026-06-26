class Solution {
    public int characterReplacement(String s, int k) {
        int st = 0;
        int maxlen = 0;
        int[] fmap = new int[26];
        int maxf = 0;
        for(int end = 0; end < s.length(); end++) {
            int idx = s.charAt(end) - 'A';
            fmap[idx]++;
            maxf = Math.max(maxf, fmap[idx]);
            if((end-st + 1) - maxf > k) {
                fmap[s.charAt(st++) - 'A']--;
            }
            maxlen = Math.max(maxlen, (end-st+1));
        }
        return maxlen;
    }
}
