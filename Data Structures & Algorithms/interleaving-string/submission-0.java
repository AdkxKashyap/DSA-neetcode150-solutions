class Solution {
    String s1;
    String s2;
    String s3;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s3.length() == 0) return true;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        return helper( 0, 0);
    }

    private boolean helper(int i, int j) {
        if(i >= s1.length() && j >= s2.length()) return true;
        boolean ans = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j))
            ans |= helper(i + 1, j);

        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j))
            ans |= helper(i, j + 1);

        return ans;
    }
}
