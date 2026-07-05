class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] cache = new int[m + 1][n + 1];

        for(int idx1 = m - 1; idx1 >= 0; idx1--) {
            for(int idx2 = n - 1; idx2 >= 0; idx2--) {
                if(text1.charAt(idx1) == text2.charAt(idx2)) cache[idx1][idx2] =  1 + cache[idx1 + 1][idx2 + 1];

                else cache[idx1][idx2] = Math.max(cache[idx1 + 1][idx2], cache[idx1][idx2 + 1]);
            }
        }
        return cache[0][0];
    }
}
