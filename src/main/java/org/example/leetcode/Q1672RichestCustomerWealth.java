package org.example.leetcode;

public class Q1672RichestCustomerWealth {
    public static void main(String[] args) {
        int [][] accounts = {{1,2,3},{3,2,1}};
        int [][] accounts2 = {{1,5},{7,3}, {3,5}};
        int [][] accounts3 = {{2,8,7},{7,1,3}, {1,9,5}};

        System.out.println("Result: " + maximumWealth(accounts) );
        System.out.println("Result: " + maximumWealth(accounts2) );
        System.out.println("Result: " + maximumWealth(accounts3) );

    }

    public static int maximumWealth(int[][] accounts) {
        int richest = 0;
        int running = 0;
        for(int i = 0; i < accounts.length; i++){
            running = 0;
            for(int j = 0; j < accounts[i].length; j++){
                running += accounts[i][j];
            }
            if(richest < running){
                richest = running;
            }
        }
        return richest;
    }
}
