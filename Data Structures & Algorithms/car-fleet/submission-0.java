class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n == 0) return 0;
        double[][] cars = new double[n][2];
        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (target - position[i] * 1d) / speed[i];
        }
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        
        int fleets = 1;
        double time = cars[n-1][1];
        for(int i = n-2; i >= 0; i--) {
            if(cars[i][1] > time) {
                fleets++;
                time = cars[i][1];
            }
        }
        return fleets;
    }
}
