class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int nrows = matrix.length;
        int ncols = matrix[0].length;
        int top = 0;
        int bottom = nrows - 1;
        int left = 0;
        int right = ncols - 1;
        List<Integer> res = new ArrayList<>();

        while(top <= bottom && left <= right) {
            //l -> r. top fixed
            for(int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // top -> bottom: Right fixed.
            for(int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            //right -> left: Bottom fixed
            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
            }
            bottom--;
            
            //Bottom -> top: left fixed
            if(left <= right){
                for(int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;  
        }
        return res;
    }
}
