class Solution {
    public int maxProfit(int[] prices) {

        int i = 0;       // Buy karne ka day
        int j = 1;       // Sell karne ka day
        int res = 0;     // Maximum profit

        while (j < prices.length) {

            // Agar selling price > buying price hai
            if (prices[j] > prices[i]) {

                int diff = prices[j] - prices[i];

                // Maximum profit store karo
                res = Math.max(res, diff);

                j++;

            } else {

                // Agar current price cheaper hai,
                // to naya buy point bana do
                i = j;
                j++;
            }
        }

        return res;
    }
}