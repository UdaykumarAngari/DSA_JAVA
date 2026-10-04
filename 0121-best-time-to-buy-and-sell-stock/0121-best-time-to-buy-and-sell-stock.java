class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        //int cost;
        for(int i = 1; i < prices.length ; i++){
            // cost = prices[i] - min;
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}