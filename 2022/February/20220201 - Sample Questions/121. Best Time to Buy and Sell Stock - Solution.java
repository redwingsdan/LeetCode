class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;
    	for (int i = 1; i < prices.length; i++) {
   			buyPrice = Math.min(buyPrice, prices[i]); //get the min buy price
   			profit = Math.max(profit, prices[i] - buyPrice); //Check to see if selling at the current price gives more profit
    	}
    	return profit;
    }
}