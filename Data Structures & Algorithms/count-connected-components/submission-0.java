class Solution {
    private int[] par;
    private int[] rank;
    public int countComponents(int n, int[][] edges) {
        par = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            par[i] = i;
        }
        for(int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(par[i] == i) count++;
        }
        return count;
    }

    private int find(int x) {
        if(par[x] == x) return x;
        return find(par[x]);
    }

    private void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if(parA == parB) return;
        if(rank[parA] > rank[parB]) par[parB] = parA;
        else if(rank[parA] < rank[parB]) par[parA] = parB;
        else {
            par[parB] = parA;
            rank[parA]++;
        }
    }
}
