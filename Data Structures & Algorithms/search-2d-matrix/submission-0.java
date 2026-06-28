class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nrows = matrix.length;
        int ncols = matrix[0].length;
        //find the correct row using bs.
        int left = 0;
        int right = nrows - 1;
        int srow = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int min = matrix[mid][0];
            int max = matrix[mid][ncols - 1];
            if(max < target) left = mid + 1;
            else if(min > target) right = mid - 1;
            else {
                srow = mid;
                break;
            }
        }
        if(srow == -1) return false;
        left = 0; 
        right = ncols - 1;

        while(left <= right) {
            int mid = (left + right)/2;
            if(target == matrix[srow][mid]) return true;
            if(target < matrix[srow][mid]) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
