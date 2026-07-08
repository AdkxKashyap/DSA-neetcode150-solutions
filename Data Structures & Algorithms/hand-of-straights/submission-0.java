class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        int maxHand = 0;
        int minHand = 1000;
        
        int[] fmap = new int[1001];
        for(int num : hand) {
            fmap[num]++;
            maxHand = Math.max(maxHand, num);
            minHand = Math.min(minHand, num);
        }

        for(int i = minHand; i <= maxHand; i++) {
            if(fmap[i] == 0) continue;
            int count = fmap[i];
            int sz = i + groupSize;
            for(int j = i; j < sz; j++) {
                if(fmap[j] < count) return false;
                fmap[j] -= count;
            }
        }

        return true;
    }
}
