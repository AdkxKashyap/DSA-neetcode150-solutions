class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int max = 0;
        int st = -1;
        int end = -1;
        for(int i = n-1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(i == j) dp[i][j] = 1;
                else if(j - i == 1 && s.charAt(i) == s.charAt(j)) dp[i][j] = 2;
                else{
                    if(s.charAt(i) == s.charAt(j) && i < n - 1 && j > 0 && dp[i+1][j-1] > 0) {
                        dp[i][j] = 2 + dp[i+1][j-1];
                    }
                }
                if(dp[i][j] > max) {
                    st = i;
                    end = j;
                    max = dp[i][j];
                }
            }
        }
        return s.substring(st, end + 1);
    }
}
