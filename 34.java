class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int [2];
        result[0] = -1;
        result[1] = -1;
        if (binarySearch(nums, target)) {
            result[0] = binarySearch(nums, target - 0.5);
            result[1] = binarySearch(nums, target + 0.5) - 1;
        }
        return result;
    }

    public int binarySearch(int[] nums, double target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) high = mid - 1;
            if (nums[mid] < target) low = mid + 1;
        }
        return low;
    }

    public boolean binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > target) high = mid - 1;
            if (nums[mid] < target) low = mid + 1;
        }
        return false;
    }
}