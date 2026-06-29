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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return helper(root, subRoot);
    }
    private boolean isSame(TreeNode p, TreeNode q) {
        if(p == null || q == null) {
            return p == null && q == null ? true : false;
        }

        return isSame(p.left, q.left) && isSame(p.right, q.right) && p.val == q.val;
    }
    private boolean helper(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        if(root.val == subRoot.val && isSame(root, subRoot)) return true;
        return helper(root.left, subRoot) || helper(root.right, subRoot);
    }
}
