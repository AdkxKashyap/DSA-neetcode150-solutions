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

public class Codec {

    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(',');
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    private int idx = 0;
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return buildTree(arr);
    }

    private TreeNode buildTree(String[] arr) {
        String val = arr[idx++];
        if(val.equals("N")) return null;
        TreeNode nn = new TreeNode(Integer.parseInt(val));
        nn.left = buildTree(arr);
        nn.right = buildTree(arr);
        return nn;
    }
}
