package org.example;

import java.util.*;

public class Q448NumbersDisappearedInArray {

    public static void main(String[] args) {
        int [] nums = {4,3,2,7,8,2,3,1};
        int [] nums2 = {1,1};

        System.out.println(Arrays.toString(nums) + ": " + findDisappearedNumbers(nums));
        System.out.println(Arrays.toString(nums2) + ": " + findDisappearedNumbers(nums2));

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List result = new ArrayList();
        Map<Integer, Boolean> map = new HashMap();

        for(int i = 0; i < nums.length; i++){

            map.put(nums[i], true);
        }
        System.out.println("Map: " + map);

        for(int i = 0; i <= nums.length; i++) {
            if(!map.containsKey(i) && i != 0){
                result.add(i);
            }
        }

        return result;
    }

}
