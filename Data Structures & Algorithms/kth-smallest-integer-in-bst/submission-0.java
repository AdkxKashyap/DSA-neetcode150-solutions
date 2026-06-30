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
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return helper(root, null);
    }

    private int helper(TreeNode root, TreeNode prev) {
        if(root == null) return 0;

        int left = helper(root.left, prev);
        if(left != 0) return left;

        k--;
        if(k == 0) return root.val;

        prev = root;

        return helper(root.right, prev);
    }
}
