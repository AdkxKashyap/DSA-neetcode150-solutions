/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Node[] map;
    public Node cloneGraph(Node node) {
        map = new Node[101];
        return helper(node);
    }

    private Node helper(Node node) {
        if(node == null) return null;
        if(map[node.val] != null) return map[node.val];
        Node nn = new Node(node.val);
        map[nn.val] = nn;
        for(Node nbr : node.neighbors) {
            Node child = helper(nbr);
            nn.neighbors.add(child);
        }
        return nn;
    }
}