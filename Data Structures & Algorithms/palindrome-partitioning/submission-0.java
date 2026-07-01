class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        helper(s, res, new ArrayList<>(),dp, 0);
        return res;
    }

    private void helper(String s, List<List<String>> res, List<String> asf,boolean[][] dp, int start) {
        if(start == s.length()) {
            res.add(new ArrayList<>(asf));
            return;
        }
        for(int end = start; end < s.length(); end++) {
            if(isPalindromeV2(start, end, s, dp) == true) {
                dp[start][end] = true;
                asf.add(s.substring(start, end+1));
                helper(s, res, asf, dp, end+1);
                asf.remove(asf.size() - 1);
            }
        }
    }
    // we can use dp to store the result of palindrome check for each substring, so that we don't have to check it again and again for the same substring. This will reduce the time complexity from O(n^3) to O(n^2).
    private boolean isPalindromeV2(int start, int end, String s, boolean[][] dp) {
        if(s.length() == 0) return false;
        if(s.charAt(start) != s.charAt(end)) return false;
        //"aba"
        if(end-start <= 2) return true;
        return dp[start+1][end-1];
    }
}