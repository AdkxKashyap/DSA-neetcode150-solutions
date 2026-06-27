class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++) {
            String cur = strs.get(i);
            sb.append(cur.length()).append("#").append(cur);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            StringBuilder sb = new StringBuilder();
            while(str.charAt(i) != '#') {
                sb.append(str.charAt(i));
                i++;
            }
            i++;
            int len = Integer.parseInt(sb.toString());
            
            res.add(str.substring(i, i + len));
            i+=len;
        }
        return res;
    }
}
