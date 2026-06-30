class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int num : stones) {
            pq.offer(num);
        }
        while(pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            int res = Math.abs(s1 - s2);
            if(res != 0) pq.offer(res);
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }
}
