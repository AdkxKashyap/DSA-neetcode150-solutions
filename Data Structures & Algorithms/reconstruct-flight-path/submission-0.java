class Solution {

    Map<String, PriorityQueue<String>> graph;
    LinkedList<String> ans;

    public List<String> findItinerary(List<List<String>> tickets) {

        graph = new HashMap<>();
        ans = new LinkedList<>();

        // Build graph
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                 .offer(ticket.get(1));
        }

        dfs("JFK");
        return ans;
    }

    private void dfs(String src) {

        PriorityQueue<String> pq = graph.get(src);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }

        // Airport is finalized only after all outgoing flights are used
        ans.addFirst(src);
    }
}