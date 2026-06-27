class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            while(!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]) {
                int idx = stk.pop();
                res[idx] = i - idx;
            }
            stk.push(i);
        }
        return res;
    }
}
