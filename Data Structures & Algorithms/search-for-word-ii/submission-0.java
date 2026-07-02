class Solution {
    private class TreeNode {
        TreeNode[] children = new TreeNode[26];
        String word = null;
    }

    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int nrow;
    private int ncol;
    public List<String> findWords(char[][] board, String[] words) {
        TreeNode root = buildTree(words);
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        nrow = board.length;
        ncol = board[0].length;

        for(int i = 0; i < nrow; i++) {
            for(int j = 0; j < ncol; j++) {
                char ch = board[i][j];
                TreeNode curr = root.children[ch -'a'];
                if(curr != null) search(board, curr, res, i, j);
            }
        }

        return res;
    }

    private void search(char[][] board, TreeNode curr, List<String> res, int row, int col) {
        if(curr.word != null) {
            res.add(curr.word);
            //Same word if found again should not be added in res.
            curr.word = null;
        }
        char tmp = board[row][col];
        // Mark visited
        board[row][col] = '#';
        for(int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr < 0 || nr >= nrow || nc < 0 || nc >= ncol || board[nr][nc] == '#') continue;
            char ch = board[nr][nc];
            TreeNode node = curr.children[ch - 'a'];
            if(node != null) {
                search(board, node, res, nr, nc);
            }
        }
        board[row][col] = tmp;
    }

    private TreeNode buildTree(String[] words) {
        TreeNode root = new TreeNode();
        for(String word : words) {
            insert(root, word);
        }
        return root;
    }

    private void insert(TreeNode root, String word) {
        TreeNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch - 'a'] == null) curr.children[ch - 'a'] = new TreeNode();
            curr = curr.children[ch-'a'];
        }
        curr.word = word;
    }
}
