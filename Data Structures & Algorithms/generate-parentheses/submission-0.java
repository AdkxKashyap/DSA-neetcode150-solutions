class Solution {
    List<String> res;
    int n;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        this.n = n;
        helper(new StringBuilder(), 0, 0);
        return res;
    }

    private void helper(StringBuilder sb, int open, int close) {
        if(sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if(open < n) {
            sb.append('(');
            helper(sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open) {
            sb.append(')');
            helper(sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
