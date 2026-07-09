class Solution {
    public void rotate(int[][] matrix) {
        int nrows = matrix.length;
        int ncols = matrix[0].length;

        for(int i = 0; i < nrows; i++) {
            for(int j = i; j < ncols; j++) {
                   swap(matrix, i, j, j, i); 
            }
        }

        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols/2; j++) {
                swap(matrix, i, j, i, ncols - j - 1);
            }
        }
    }

    private void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int tmp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = tmp;
    }
}
