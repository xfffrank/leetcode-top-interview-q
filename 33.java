class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] >= nums[low]) {
                // e.g. [4,5,6,7,1,2,3], target = 1
                if (target >= nums[low] && target < nums[mid])
                    // add "=" because the target could be at the "low" position
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                // e.g. [7,1,2,3,4,5,6], target = 1
                if (target > nums[mid] && target <= nums[high])
                    // add "=" because the target could be at the "high" position
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }
}