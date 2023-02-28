package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q14LongestCommonPrefix {

    public static void main(String[] args) {

//        String [] strs = {"flower","flow","flight"};
//        String [] strs = {"ab", "a"};
//        String [] strs = {"flower","flower","flower","flower"};
        String [] strs = {"a","a","b"};
//        String [] strs = {"dog","racecar","car"};

        System.out.println("Input: " + Arrays.toString(strs));
        System.out.println("Result: " + longestCommonPrefix(strs));


    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        String result = "";
        String start = strs[0];
        Map<String, Integer> map = new HashMap();

        for(int i = 1 ; i < strs.length; i++){
            for(int j = 0; j <= start.length(); j++){

                if(strs[i].startsWith(start.substring(0, j))){

                        if (map.containsKey(start.substring(0, j))) {
                            int count = map.get(start.substring(0, j));
                            count++;
                            map.put(start.substring(0, j), count);

                        } else {
                            map.put(start.substring(0, j), 2);
                        }
                }
            }
        }
        int max = 0;
        int strLength = 0;
        for(String key : map.keySet()) {
            int count = map.get(key);
            if (count >= max && key.length() > strLength && count == strs.length) {
                max = count;
                result = key;
                strLength = key.length();
            }
        }
        return result;
    }

}
