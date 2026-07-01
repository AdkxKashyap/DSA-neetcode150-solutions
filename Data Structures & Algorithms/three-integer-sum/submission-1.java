class Solution {
    List<List<Integer>> res ;
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>(); 
        for(int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            twoSum(nums, i);
        }
        return res;
    }

    private void twoSum(int[] numbers, int idx) {
        int left = idx + 1;
        int right = numbers.length - 1;
        int target = -numbers[idx];
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum < target) left ++;
            else if(sum > target) right --;
            else {
                res.add(Arrays.asList(numbers[idx], numbers[left++], numbers[right--]));
                while(left < numbers.length && numbers[left] == numbers[left - 1]) left++;
                while(right >= 0 && numbers[right] == numbers[right + 1]) right--;
            }
        }
    }
}
