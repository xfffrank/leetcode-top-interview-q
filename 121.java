class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length == 0) return 0;

        int maxProfit = 0, currMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > currMin)
                maxProfit = Math.max(maxProfit, prices[i] - currMin);
            else
                currMin = prices[i];
        }

        return maxProfit;
    }
}