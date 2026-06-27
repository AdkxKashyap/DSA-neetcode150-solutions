class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int n = s.length();
        int[] smap = new int[26];
        int[] tmap = new int[26];
        for(int i = 0; i < n; i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            smap[schar - 'a']++;
            tmap[tchar - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(smap[i] != tmap[i]) return false;
        }
        return true;
    }
}
