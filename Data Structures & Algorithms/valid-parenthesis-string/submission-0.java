class Solution {
    int slen = 0;
    Boolean[][] cache;
    public boolean checkValidString(String s) {
        slen = s.length();
        cache = new Boolean[slen][slen];
        return dfs(s, 0, 0);
    }

    private boolean dfs(String s, int idx, int top) {
        if(idx >= slen) return top == 0;
        if(cache[idx][top] != null) return cache[idx][top];
        char ch = s.charAt(idx);
        if(ch == '(') {
            if(dfs(s, idx + 1, top + 1)) return cache[idx][top] = true;
        }

        else if(ch == ')') {
            if(top > 0 && dfs(s, idx + 1, top - 1)) return cache[idx][top] = true;
        }

        else {
            if(dfs(s, idx + 1, top)) return cache[idx][top] = true;
            if(dfs(s, idx + 1, top + 1)) return cache[idx][top] = true;
            if( top > 0 && dfs(s, idx + 1, top - 1)) return cache[idx][top] = true;
        }

        return cache[idx][top] = false;
    }
}