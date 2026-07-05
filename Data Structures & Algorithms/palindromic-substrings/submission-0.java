class Solution {
    int st;
    int end;
    int slen;
    int count;
    public int countSubstrings(String s) {
        slen = s.length();
        count = 0;
        for(int i = 0; i < slen; i++) {
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return count;
    }

    private void expand(String s, int left, int right) {
        while(left >= 0 && right < slen && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
    }
}
