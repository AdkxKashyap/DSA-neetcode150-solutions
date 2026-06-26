class Solution {
    public boolean checkInclusion(String s, String t) {
        int[] smap = new int[26];
        int st = 0;

        for(char ch : s.toCharArray()) {
            smap[ch - 'a']++;
        }
        for(int end = 0; end < t.length(); end++) {
            int idx = t.charAt(end)-'a';
            smap[idx]--;
            while(smap[idx] < 0) {
                smap[t.charAt(st)-'a']++;
                st++;
            }
            if((end - st + 1) == s.length()) return true;
        }
        return false;
    }
}
