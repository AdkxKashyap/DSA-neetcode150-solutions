class Solution {
    public String minWindow(String s, String t) {
        int[] smap = new int[256];
        int tmap[] = new int[256];
        int st = 0;
        int count = 0;
        int slen = s.length();
        int min = 1000;
        int minSt = -1;
        int minEnd = -1;

        for(char ch : t.toCharArray()) {
            if(tmap[ch]++ == 0) count++;
        }
        for(int end = 0; end < slen; end++) {
            if(tmap[s.charAt(end)]-- == 1) count--;
            while(count == 0) {
                int wsize = end - st + 1;
                if(wsize < min) {
                    min = wsize;
                    minSt = st;
                    minEnd = end;
                }
                if(tmap[s.charAt(st++)]++ == 0) count++;
            }
        }
        return minSt == -1 ? "" : s.substring(minSt, minEnd + 1);
    }
}
