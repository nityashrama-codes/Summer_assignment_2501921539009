class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {

            if (price < minPrice) {
                minPrice = price;
            }

            profit = Math.max(profit, price - minPrice);
        }

        return profit;
    }
}
