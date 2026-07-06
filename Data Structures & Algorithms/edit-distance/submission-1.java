class Solution {
    int n1;
    int n2;
    int[][] cache;
    public int minDistance(String word1, String word2) {
        n1 = word1.length();
        n2 = word2.length();
        cache = new int[n1][n2];
        for(int[] ch : cache) Arrays.fill(ch, -1);
        return helper(word1, word2, 0, 0);
    }

    private int helper(String w1, String w2, int idx1, int idx2) {
        if(idx1 >= n1) return n2 - idx2;
        if(idx2 >= n2) return n1 - idx1;
        if(cache[idx1][idx2] != -1) return cache[idx1][idx2];
        if(w1.charAt(idx1) == w2.charAt(idx2)) return helper(w1, w2, idx1 + 1, idx2 + 1);
        int ins = helper(w1, w2, idx1, idx2 + 1);
        int del = helper(w1, w2, idx1 + 1, idx2);
        int rep = helper(w1, w2, idx1 + 1, idx2 + 1);

        return cache[idx1][idx2] = 1 + Math.min(ins, Math.min(del, rep));
    }
}
