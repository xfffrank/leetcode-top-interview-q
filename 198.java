class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        int currMax = 0, preMax = 0;
        for (int num : nums) {
            int temp = currMax;
            currMax = Math.max(preMax + num, currMax);
            preMax = temp;
        }

        return currMax;
    }
}