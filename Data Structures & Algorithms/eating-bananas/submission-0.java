class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for(int p : piles) {
            right = Math.max(right, p);
        }
        while(left <= right) {
            int mid = (left + right) / 2;
            if(canEat(mid, piles, h)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    private boolean canEat(int rate, int[] piles, int h) {
        int tot = 0;
        for(int p : piles) {
            int t = p % rate == 0 ? p/rate : (p/rate) + 1;
            if(tot + t > h) return false;
            tot += t;
        }
        return true;
    }
}
