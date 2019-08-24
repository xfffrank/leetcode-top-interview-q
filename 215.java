class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);

        int l = 0, r = nums.length - 1;
        k = nums.length - k; // [2,3,1,4,5], k = 2, nums.length - k = 3
        // apply the partition function used in QuickSort
        while(l < r) {
            int pivotIndex = r;
            int i = l - 1;
            for (int j = l; j < r; j++) {
                if (nums[j] < nums[pivotIndex]) {
                    swap(nums, ++i, j);
                }
            }
            swap(nums, ++i, pivotIndex);
            if (i == k)
                break;
            else if (i > k)
                r = i - 1;
            else
                l = i + 1;
        }
        return nums[k];
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void shuffle(int arr[]) {
        Random random = new Random();
        for(int i = 0; i < arr.length; i++) {
            final int r = random.nextInt(arr.length);
            swap(arr, i, r);
        }
    }
}