class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int slen = s.length();
        Set<String> set = new HashSet<>();
        for(String str : wordDict) {
            set.add(str);
        }

        boolean[] cache = new boolean[slen + 1];
        cache[slen] = true;
        for(int i = slen - 1; i >= 0; i--) {
            for(int j = i; j < slen; j++) {
                if(set.contains(s.substring(i, j+1)) && cache[j + 1]) cache[i] = true;
            }
        }
        return cache[0];
    }
}
