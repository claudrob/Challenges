package org.example.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Q20ValidParentheses {

    public static void main(String [] args){

        String s = "()";
        System.out.println("*** Test 1 ***");
        System.out.println("Input Str: " + s);
        System.out.println("Result: " + isValid(s));

        String s2 = "()[]{}";
        System.out.println("*** Test 2 ***");
        System.out.println("Input Str: " + s2);
        System.out.println("Result: " + isValid(s2));

        String s3 = "(]";
        System.out.println("*** Test 3 ***");
        System.out.println("Input Str: " + s3);
        System.out.println("Result: " + isValid(s3));

        String s4 = "([)]";
        System.out.println("*** Test 4 ***");
        System.out.println("Input Str: " + s4);
        System.out.println("Result: " + isValid(s4));

        String s5 =  "]";
        System.out.println("*** Test 5 ***");
        System.out.println("Input Str: " + s5);
        System.out.println("Result: " + isValid(s5));

        String s6 = "[";
        System.out.println("*** Test 6 ***");
        System.out.println("Input Str: " + s6);
        System.out.println("Result: " + isValid(s6));
    }


    public static boolean isValid(String s) {
        boolean result = true;
        Stack <Character> stack = new Stack<>();
        HashMap<Character, Character> characterHashMap = new HashMap<>();
        characterHashMap.put('}', '{');
        characterHashMap.put(']', '[');
        characterHashMap.put(')', '(');

        for(int i = 0; i < s.length(); i++ ){
            Character temp = s.charAt(i);
            if(characterHashMap.containsValue(temp)){
                stack.push(temp);
            }
            if(characterHashMap.containsKey(temp)){
                if(!stack.isEmpty() && stack.peek().equals(characterHashMap.get(temp))){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return result;
    }

    public static boolean isValidGood(String s) {
        Stack<Character> parentheses = new Stack<>();
        boolean result = true;
        int countCurly = 0;
        int countRound = 0;
        int countSquare = 0;

        for(int i = 0; i < s.length(); i++){
            Character temp = s.charAt(i);
            switch (temp){
                case '(':
                    parentheses.push(temp);
                    countRound++;
                    break;
                case ')':
                    if(parentheses.isEmpty())
                        return false;
                    Character c = parentheses.pop();
                    if(!c.equals('(')){
                        return false;
                    }
                    if(countRound > 0) {
                        countRound--;
                    }
                    else{
                        return false;
                    }
                    break;
                case '{':
                    parentheses.push(temp);
                    countCurly++;
                    break;
                case '}':
                    if(parentheses.isEmpty())
                        return false;
                     c = parentheses.pop();
                    if(!c.equals('{')){
                        return false;
                    }
                    if(countCurly >0){
                        countCurly--;
                    }
                    else{
                        return false;
                    }
                    break;
                case '[':
                    parentheses.push(temp);
                    countSquare++;
                    break;
                case ']':
                    if(parentheses.isEmpty())
                        return false;
                    c = parentheses.pop();
                    if(!c.equals('[')){
                        return false;
                    }
                    if(countSquare > 0) {
                        countSquare--;
                    }
                    else{
                        return false;
                    }
                    break;

            }
        }
        if(countRound== 0 && countCurly == 0 && countSquare == 0)
            return true;

        return false;

    }

    public static boolean isValidDraft(String s) {

        boolean result = true;
        int countCurly = 0;
        int countRound = 0;
        int countSquare = 0;

        for(int i = 0; i < s.length(); i++){
            Character temp = s.charAt(i);
            switch (temp){
                case '(':
                    countRound++;
                    break;
                case ')':
                    if(countRound > 0) {
                        countRound--;
                    }
                    else{
                        return false;
                    }
                    break;
                case '{':
                    countCurly++;
                    break;
                case '}':
                    if(countCurly >0){
                        countCurly--;
                    }
                    else{
                        return false;
                    }
                    break;
                case '[':
                    countSquare++;
                    break;
                case ']':
                    if(countSquare > 0) {
                        countSquare--;
                    }
                    else{
                        return false;
                    }
                    break;

            }
        }
        if(countRound== 0 && countCurly == 0 && countSquare == 0)
            return true;

        return false;

    }

}
