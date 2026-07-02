class Solution {
    private int[] par;
    private int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        par = new int[n + 1];
        rank = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            par[i] = i;
        }
        int[] res = new int[2];
        for(int[] edge : edges) {
            res = union(edge[0], edge[1]);
            if(res[0] != -1) return res;
        }
        return res;
    }

    private int find(int x) {
        if(par[x] == x) return x;
        return par[x] = find(par[x]);
    }

    private int[] union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if(parA == parB) return new int[]{a, b};
        if(rank[parA] > rank[parB]) par[parB] = parA;
        else if(rank[parA] < rank[parB]) par[parA] = parB;
        else {
            par[parB] = parA;
            rank[parA]++;
        }
        return new int[]{-1, -1};
    }
}
