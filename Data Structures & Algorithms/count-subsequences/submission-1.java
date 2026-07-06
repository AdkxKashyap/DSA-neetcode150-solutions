class Solution {
    int[][] cache;
    public int numDistinct(String s, String t) {
        cache = new int[s.length()][t.length()];
        for(int[] ch : cache) Arrays.fill(ch, -1);
        return helper(s, t, 0, 0);
    }

    private int helper(String s, String t, int idx1, int idx2) {
        if(idx2 >= t.length()) return 1;
        if(idx1 >= s.length()) return 0;
        if(cache[idx1][idx2] != -1) return cache[idx1][idx2];
        int ans = 0;
        if(s.charAt(idx1) == t.charAt(idx2)) ans = helper(s, t, idx1 + 1, idx2 + 1);

        ans += helper(s, t, idx1 + 1, idx2);
        return cache[idx1][idx2] = ans;
    }
}
