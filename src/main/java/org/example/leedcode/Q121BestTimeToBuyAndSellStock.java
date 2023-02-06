package org.example.leedcode;

import java.util.Arrays;

public class Q121BestTimeToBuyAndSellStock {

    public static void main(String []args){
        int [] prices = {7,1,5,3,6,4};
        System.out.println("Test 1");
        System.out.println("Input:  " + Arrays.toString(prices));
        System.out.println("Result: " + maxProfit(prices));


    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int bestBuy = prices[0];
        int buyIndex = 0;

        int bestSell = 0;
        int sellIndex = 0;
        for(int i = 1; i < prices.length; i++){
            // better price to buy
            if(prices[i] < bestBuy){
                bestBuy = prices[i];
                buyIndex = i;
                bestSell = 0;
                sellIndex = 1;
            }

            //  better price to sell
            if(prices[i] > bestSell){
                bestSell = prices[i];
                sellIndex = i;
            }

            // profit
            if((bestSell - bestBuy) > profit && sellIndex > buyIndex){
                profit = bestSell - bestBuy;
            }
        }


        return profit;
    }


}
