package org.example.leetcode;

import java.util.Arrays;

public class Q1TwoSum {

    public static void main(String[] args){
        int []nums = {2,7,11,15};
        int target = 9;
        System.out.println("Test1: " +Arrays.toString(solution(nums, target)));

        int [] nums2 = {3,2,4};
        target = 6;
        System.out.println("Test2: " +Arrays.toString(solution(nums2, target)));

        int [] nums3 = {3,3};
        int target3 = 6;
        System.out.println("Test3: " +Arrays.toString(solution(nums3, target3)));

    }

    static int[] solution(int[] nums, int target){
        int result [] = new int[2];
        for(int i = 0; i < nums.length-1; i++){
            for(int j = 0; j < nums.length; j++){

                if(i != j && (nums[i] + nums [j]) == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;

    }

    static int[] solution2(int[] nums, int target){
        int result [] = new int[2];

        return result;

    }

}
