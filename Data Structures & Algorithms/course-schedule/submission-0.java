class Solution {
    List<List<Integer>> adj;
    boolean[] path;
    boolean[] vis;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = buildAdjList(numCourses, prerequisites);
        path = new boolean[numCourses];
        vis = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!vis[i] && isCyclic(i)) return false;
        }
        return true;
    }

    private boolean isCyclic(int src) {
        path[src] = true;
        vis[src] = true;
        boolean res = true;
        for(int nbr : adj.get(src)) {
          if((!vis[nbr] && isCyclic(nbr)) || path[nbr]) return true;
        }
        path[src] = false;
        return false;
    }

    private List<List<Integer>> buildAdjList(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : pre) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
        }
        return adj;
    }
}
