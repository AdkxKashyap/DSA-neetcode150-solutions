class Solution {
    int slen = 0;
    int plen = 0;
    public boolean isMatch(String s, String p) {
        slen = s.length();
        plen = p.length();
        return helper(s, p, 0, 0);
    }

    private boolean helper(String s, String p, int idx1, int idx2) {
        if(idx2 >= plen) return idx1 == slen ? true : false;
        /* Cannot return true b4 pattern ends*/
        // if(idx1 >= slen) return true;

        boolean doesCharMatch = idx1 < slen  && (p.charAt(idx2) == '.' || s.charAt(idx1) == p.charAt(idx2));

        if(idx2 + 1 < plen && p.charAt(idx2 + 1) == '*') {
            boolean skip = helper(s, p, idx1, idx2 + 2);
            boolean take = doesCharMatch && helper(s, p, idx1 + 1, idx2);
            return skip || take;
        }

        return doesCharMatch && helper(s, p, idx1 + 1, idx2 + 1);
    }
}
