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
    int idx = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
        if(left > right) return null;
        int rootval = preorder[idx++];
        int splitidx = map.get(rootval);
        TreeNode root = new TreeNode(rootval);

        root.left = helper(preorder, inorder, left, splitidx-1);
        root.right = helper(preorder, inorder, splitidx + 1, right);
        return root;
    }
}
