class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int st = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if(map.containsKey(ch)) st = Math.max(st, map.get(ch) + 1);
            map.put(ch, end);
            res = Math.max(res, (end - st) + 1);
        }
        return res;
    }
}
