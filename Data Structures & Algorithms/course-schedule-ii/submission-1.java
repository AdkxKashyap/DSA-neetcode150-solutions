class Solution {
    private List<List<Integer>> adj;
    private boolean[] vis;
    private boolean[] path;
    Deque<Integer> stk;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = buildAdj(numCourses, prerequisites);
        vis = new boolean[numCourses];
        path = new boolean[numCourses];
        int[] res = new int[numCourses];
        stk = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++) {
            if(!vis[i] && isCyclic(i)) return new int[]{};
        }
        int idx = 0;
        while(!stk.isEmpty()) {
            res[idx++] = stk.pop();
        }
        return res;
    }

    private boolean isCyclic(int src) {
        vis[src] = true;
        path[src] = true;
        for(int nbr : adj.get(src)) {
            if((!vis[nbr] && isCyclic(nbr)) || path[nbr]) return true;
        }
        path[src] = false;
        stk.push(src);
        return false;
    }

    private List<List<Integer>> buildAdj(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        return adj;
    }
}
