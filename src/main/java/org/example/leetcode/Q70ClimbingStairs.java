package org.example.leetcode;

public class Q70ClimbingStairs {

    public static void main(String [] args){
        System.out.println("Counting stairs:");
        for(int i = 1; i <= 45; i++){
            System.out.println("Climbing options for \'" + i + "\' stairs: " + climbStairs(i));
        }
    }




    public static int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        int [] count = new int[n];

        count[0] = 1;
        count[1] = 2;
        for(int i = 2; i < n; i++){
            count[i] = count[i - 1] + count[i - 2];
        }


        return count[n -1];
    }

}
