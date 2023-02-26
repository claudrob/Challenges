package org.example.leetcode;

import java.util.HashMap;

public class Q169MajorityElement {

    public static void main(String[] args) {
        int [] nums = {3,2,3};

        int [] nums2 = {2,2,1,1,1,2,2};

        System.out.println("Result: "  + majorityElement(nums));
        System.out.println("Result: "  + majorityElement(nums2));
    }


    public static int majorityElement(int[] nums) {
        int result = 0;
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){

                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }
        for(int key : map.keySet()){
            int val = map.get(key);
            if(val > (n / 2)){
                return key;
            }
        }

        return result;

    }


}
