class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] fmap = new int[26];
        for(char ch : tasks) {
            fmap[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int freq : fmap) {
            if(freq > 0) pq.offer(freq);
        }
        int count = 0;
        while(!pq.isEmpty()) {
            int slots = n+1;
            List<Integer> rem = new ArrayList<>();
            while(!pq.isEmpty() && slots > 0) {
                slots--;
                int freq = pq.poll();
                count++;
                if(freq - 1 > 0) rem.add(freq - 1);
            }
            for(int f : rem) {
                pq.offer(f);
            }
            if(!pq.isEmpty()) count += slots;
        }
        return count;
    }
}
