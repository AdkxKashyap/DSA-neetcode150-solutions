class Solution {
    private boolean[] vis;
    private List<List<Integer>> adj;
    public boolean validTree(int n, int[][] edges) {
        adj = buildAdj(n, edges);
        vis = new boolean[n];
        boolean flag = false;

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                if(isCyclic(i, -1) || flag) return false;
                flag = true;
            }
        }
        return true;
    }

    private boolean isCyclic(int src, int par) {
        vis[src] = true;
        for(int nbr : adj.get(src)) {
            if((nbr != par && vis[nbr]) || !vis[nbr] && isCyclic(nbr, src)) return true;
        }
        return false;
    }

    private List<List<Integer>> buildAdj(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }
}
