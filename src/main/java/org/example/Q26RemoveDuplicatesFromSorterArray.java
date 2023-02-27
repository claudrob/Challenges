package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q26RemoveDuplicatesFromSorterArray {

    public static void main(String[] args) {

        int [] nums = {1,1,2};
        int [] nums2 = {0,0,1,1,1,2,2,3,3,4};

        System.out.println(Arrays.toString(nums) + ": " + removeDuplicates(nums) );
        System.out.println("Result :  " + Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2) + ": " + removeDuplicates(nums2) + " :  " + Arrays.toString(nums));
        System.out.println("Result :  " + Arrays.toString(nums2));

    }

    public static int removeDuplicates(int[] nums) {
        int k = 0;

        Map<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }

        for(int val: list){
            System.out.println(val);
            nums[k] = val;
            k++;
        }
        return k;
    }

}
