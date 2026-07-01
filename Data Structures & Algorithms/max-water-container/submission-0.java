class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        while(left < right) {
            if(heights[left] < heights[right]) {
                max = Math.max(max, heights[left] * (right - left));
                left++;
            }
            else {
                max = Math.max(max, heights[right] * (right - left));
                right--;
            }
        }
        return max;
    }
}
