class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = nums[i] + (currSum < 0 ? 0 : currSum);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}