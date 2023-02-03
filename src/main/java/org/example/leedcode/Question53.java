package org.example.leedcode;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;

public class Question53 {


    public static int maxSubArray(int[] nums) {
        int start = 0;
        int end = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = nums.length - 1; j > 0; j--){
                int sum = sum(Arrays.copyOfRange(nums, i, j));
                if(sum > max){
                    sum =
                }
            }

        }

        return max;
    }

    private static int sum(int[] nums){
        return Arrays.stream(nums).sum();


    }

}
