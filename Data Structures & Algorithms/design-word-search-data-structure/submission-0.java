class WordDictionary {
    private class TreeNode {
        TreeNode[] children = new TreeNode[26];
        boolean isWord = false;
    }

    private TreeNode root = null; 
    public WordDictionary() {
        root = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode curr = root;
        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if(curr.children[idx] == null) curr.children[idx] = new TreeNode();
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return helper(root, 0, word);
    }

    private boolean helper(TreeNode curr, int idx, String word) {
        if(idx == word.length()) return curr.isWord;
        char ch = word.charAt(idx);
        if(ch == '.') {
            for(TreeNode node : curr.children) {
                if(node != null && helper(node, idx + 1, word)) return true;
            }
        }
        else {
            TreeNode node = curr.children[ch - 'a'];
            if(node != null) return helper(node, idx + 1, word);
        }
        return false;
    }
}
