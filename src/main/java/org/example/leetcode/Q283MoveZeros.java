package org.example.leetcode;

import java.util.Arrays;

public class Q283MoveZeros {

    public static void main(String [] args){

        int [] nums = {0,1,0,3,12};
        System.out.println("Before Sorting: ");
        System.out.println(Arrays.toString(nums));

        moveZeroes(nums);

        System.out.println("After Sorting: ");
        System.out.println(Arrays.toString(nums));

    }

    public static void moveZeroes(int[] nums) {
        int numberOfZeros = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                numberOfZeros++;
            }
            else if(nums[i] != 0 && numberOfZeros > 0){
                nums[i - numberOfZeros] = nums[i];
            }
        }
        for(int j = nums.length - 1; j > ((nums.length - 1) - numberOfZeros); j-- ){
            nums[j] = 0;
        }
    }

}
