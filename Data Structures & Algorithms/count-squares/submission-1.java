class CountSquares {

    private int[][] freq;
    private List<int[]> points;

    public CountSquares() {
        freq = new int[1001][1001];
        points = new ArrayList<>();
    }

    public void add(int[] point) {
        freq[point[0]][point[1]]++;
        points.add(point);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int ans = 0;

        for (int[] p : points) {
            int x2 = p[0];
            int y2 = p[1];

            if (x == x2 || Math.abs(x - x2) != Math.abs(y - y2))
                continue;

            ans += freq[x][y2] * freq[x2][y];
        }

        return ans;
    }
}