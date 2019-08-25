class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1; // the lower bound and upper bound of the range
        while (low < high) {
            int mid = (low + high) / 2, count = 0;
            for (int num: nums) {
                if (num <= mid) count++;
            }
            // If there is no duplicate number from [1, 2, ..., mid],
            // "count" should be less or equal to "mid".
            if (count <= mid) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}