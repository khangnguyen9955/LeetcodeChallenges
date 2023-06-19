class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0; 
        int buyDay = 0;
        int sellDay = 0;
        int days = prices.length;

        while(buyDay < days && sellDay < days){
            // find the smallest price 
            while(buyDay < days - 1 && prices[buyDay + 1] < prices[buyDay])
                buyDay++;
            // we have to sell after buy day 
            sellDay = buyDay;
            // find the max price
            while(sellDay < days - 1 && prices[sellDay + 1] > prices[sellDay])
                sellDay++;
            profit += prices[sellDay] - prices[buyDay];
            // now buy another stock, buy day will start from sell day + 1 
            buyDay = sellDay +1;
        }
        return profit;
    }
}