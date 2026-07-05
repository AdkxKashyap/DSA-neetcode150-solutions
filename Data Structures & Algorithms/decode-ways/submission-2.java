class Solution {
    int slen = 0;
    int[] cache;
    public int numDecodings(String s) {
        slen = s.length();
        cache = new int[slen + 1];
        cache[slen] = 1;

        for(int idx = slen - 1; idx >= 0; idx--) {
            int num1 = s.charAt(idx) - '0';
            if(num1 > 0) cache[idx] = cache[idx + 1];

            if(num1 > 0 && num1 <= 2 && idx < slen - 1) {
                int num2 = num1 * 10 + s.charAt(idx + 1) - '0';
                if(num2 <= 26) cache[idx] += cache[idx + 2];
            }
        }

        return cache[0];
    }
}
