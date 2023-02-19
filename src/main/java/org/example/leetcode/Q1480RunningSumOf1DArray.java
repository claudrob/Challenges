package org.example.leetcode;

import java.util.Arrays;

public class Q1480RunningSumOf1DArray {

    public static void main(String[] args) {

        int [] nums = {1,2,3,4};
        int [] nums2 = {1,1,1,1,1};
        int [] nums3 = {3,1,2,10,1};

        System.out.println("Input: " + Arrays.toString(nums) + ", Output: " + Arrays.toString(runningSum(nums)));
        System.out.println("Input: " + Arrays.toString(nums2) + ", Output: " + Arrays.toString(runningSum(nums2)));
        System.out.println("Input: " + Arrays.toString(nums3) + ", Output: " + Arrays.toString(runningSum(nums3)));

    }



    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int runningTotal = nums[0];
        result[0] = runningTotal;
        for(int i = 1; i < nums.length; i++){
            runningTotal += nums[i];
            result[i] = runningTotal;
        }
        return result;
    }

}
