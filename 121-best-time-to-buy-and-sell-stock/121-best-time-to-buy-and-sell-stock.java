class Solution {
    // public int maxProfit(int[] prices) {
    //     int maxP = 0;
    //     int noOfDays = prices.length;
    //     for(int i = 0; i < noOfDays - 1; i++) {
    //         for(int j = i + 1; j < noOfDays; j++) {
    //             int currP = prices[j] - prices[i];
    //             if(currP > maxP)
    //                 maxP = currP;
    //         }
    //     }
    //     return maxP;
    // }
    
    public int maxProfit(int[] prices) {
        int maxP = 0, noOfDays = prices.length, minPrice = prices[0];
        for(int i = 1; i < noOfDays; i++) {
            if(prices[i] < minPrice)
                minPrice = prices[i];
            else if(prices[i] - minPrice > maxP)
                maxP = prices[i] - minPrice;
        }
        return maxP;
    }
    
    
}