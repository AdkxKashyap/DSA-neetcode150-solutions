class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        char[] cmap = null;
        for(String str : strs) {
            cmap = new char[26];
            for(char ch : str.toCharArray()) {
                cmap[ch-'a']++;
            }
            String key = new String(cmap);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
