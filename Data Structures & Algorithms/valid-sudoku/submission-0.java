class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] blocks = new HashSet[9];
        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            blocks[i] = new HashSet<>();
        }
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') {
                    continue;
                }
                int block = 3 * (i/3) + j/3;
                if(rows[i].contains(num) || cols[j].contains(num) || blocks[block].contains(num)) return false;
                rows[i].add(num);
                cols[j].add(num);
                blocks[block].add(num);
            }
        }
        return true;
    }
}
