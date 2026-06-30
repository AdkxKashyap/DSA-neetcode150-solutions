/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        ArrayDeque<TreeNode> que = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            int sz = que.size();
            TreeNode lst = null;
            while(sz-- > 0) {
                TreeNode node = que.poll();
                lst = node;
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
            res.add(lst.val);
        }
        return res;
    }
}
