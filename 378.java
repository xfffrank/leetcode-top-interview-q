class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || k <= 0) return -1;
        int low = matrix[0][0], high = matrix[matrix.length - 1][matrix[0].length - 1];

        while (low <= high) {
            // Do not use (high + low) / 2.
            // The sum may overflow.
            int mid = low + (high - low) / 2, count = 0;
            int j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += j + 1;
            }
            if (count < k) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
}