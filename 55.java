class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (farthest < i) return false; // cannot reach the current position, return false
            farthest = Math.max(farthest, nums[i] + i); // the farthest reachable position from the current position
        }
        return true;
    }
}