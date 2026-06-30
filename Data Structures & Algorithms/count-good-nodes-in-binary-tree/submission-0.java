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
    int count = 0;
    public int goodNodes(TreeNode root) {
        helper(root, new TreeNode(-101));
        return count;
    }

    private void helper(TreeNode root, TreeNode largest) {
        if(root == null) return;
        if(root.val >= largest.val) {
            count++;
            largest = root;
        }
        helper(root.left, largest);
        helper(root.right, largest);
    }
}
