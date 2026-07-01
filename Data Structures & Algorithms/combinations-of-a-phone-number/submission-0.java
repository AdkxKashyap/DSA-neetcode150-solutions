class Solution {
    Map<Character, String> map = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        helper(digits, res, new StringBuilder(), 0);
        return res;
    }

    private void helper(String digits, List<String> res, StringBuilder ssf, int idx) {
        if(idx == digits.length()) {
            res.add(ssf.toString());
            return;
        };
        String al = map.get(digits.charAt(idx));
        for(char ch : al.toCharArray()) {
            ssf.append(ch);
            helper(digits, res, ssf, idx+1);
            ssf.deleteCharAt(ssf.length()-1);
        }
    }
}
