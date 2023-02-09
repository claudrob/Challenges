package org.example.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Q136SingleNumber {

    public static void main(String [] args){
        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums));
        int [] nums2 = {4,1,2,1,2};
        System.out.println(singleNumber(nums2));
    }

    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        Iterator<Integer> iterator = set.iterator();
        Integer result = iterator.next();
        return result;

    }

}
