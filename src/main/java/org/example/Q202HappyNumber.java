package org.example;

public class Q202HappyNumber {

    public static void main(String[] args) {

        int n = 19;
        System.out.println("Result " + n + "; " + isHappy(n));
        n = 2;
        System.out.println("Result " + n + "; " + isHappy(n));

    }

    public static boolean isHappy(int n) {
        String number = Integer.toString(n);
        int [] nums = new int[number.length()];
        for (int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(number.charAt(i) + "");
        }
        boolean result = false;
        int limit = 1000;
        int count = 0;
        while(!result && count < limit){
            count++;
            int happy = 0;
            for(int i = 0; i< nums.length; i++){
                happy += nums[i] * nums[i];
            }

            if(happy == 1){
                result = true;
                return true;
            }
            number = Integer.toString(happy);
             nums = new int[number.length()];
            for (int i = 0; i < nums.length; i++){
                nums[i] = Integer.parseInt(number.charAt(i) + "");
            }

        }

        return false;

    }
}
