package org.example.leetcode;

import java.util.Arrays;

import static java.util.Arrays.stream;

public class Q53MaxSubArray {

    public static void main(String [] args){
     int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
     System.out.println("Test 1");
     System.out.println("Input: " + Arrays.toString(nums));
     System.out.println("Response: " + maxSubArray(nums));

     int [] nums2 = {1};
     System.out.println("Test 2");
     System.out.println("Input: " + Arrays.toString(nums2));
     System.out.println("Response: " + maxSubArray(nums2));

        int [] nums3 = {5,4,-1,7,8};
        System.out.println("Test 3");
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Response: " + maxSubArray(nums3));


        int [] nums4 = {-2, 1};
        System.out.println("**** Test 4 *****");
        System.out.println("Input: " + Arrays.toString(nums4));
        int value = maxSubArray(nums4);
        System.out.println("Response: " + value);
    }

    public static int maxSubArray(int[] nums) {
        int maxValueSoFar = nums[0];
        int currentValue = nums[0];
        for(int i = 1; i < nums.length; i++){
            currentValue = currentValue + nums[i];
            if(nums[i] > currentValue){
                currentValue = nums[i];
            }
            if(currentValue > maxValueSoFar){
                maxValueSoFar = currentValue;
            }
        }
        return maxValueSoFar;
    }


    public static int maxSubArraySlow(int[] nums) {
        int start = 0;
        int end = nums.length;
        int max = Integer.MIN_VALUE;
        int [] solution = new int[nums.length];
        if(nums.length == 1){
            max = sum(nums);
            solution = nums;
        }else {


            for (int i = 0; i <= nums.length - 1; i++) {
                for (int j = nums.length - 1; j >= i; j--) {
                    int sum = sum(Arrays.copyOfRange(nums, i, (j + 1)));
                    if (sum > max) {
                        max = sum;
                        solution = Arrays.copyOfRange(nums, i, (j + 1));
                    }
                }

            }
        }
        System.out.println(Arrays.toString(solution));
        return max;
    }

    private static int sum(int[] nums){
        return Arrays.stream(nums).sum();


    }

}
