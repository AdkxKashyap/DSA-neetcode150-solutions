class PrefixTree {
    private class TreeNode {
        TreeNode[] children = new TreeNode[26];
        boolean isWord = false;
    }

    private TreeNode root = null;
    public PrefixTree() {
         root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr = root;
        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if(curr.children[idx] == null) curr.children[idx] = new TreeNode();
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TreeNode curr = root;
        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if(curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr = root;
        for(char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if(curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return true;
    }
}
