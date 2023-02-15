package org.example.leetcode;

import org.example.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q226InvertBinaryTree {

    public static void main(String[] args) {
        int [] nums = {4,2,7,1,3,6,9};
//        int [] nums = {2,1,3};
//        int [] nums = {1,2};
        System.out.println("Create Tree:");
        TreeNode root = createTree(nums);
        System.out.println("Completed created Tree:");

        ArrayList<Integer> nodeValues = BSF(root);
        System.out.println("Node Values of tree: " + nodeValues);

        TreeNode newHead = invertTree(root);
        System.out.println("*** Inverted ***");

        ArrayList<Integer> invertedValues = BSF(newHead);
        System.out.println("Inverted: " + invertedValues);




    }

    public static TreeNode invertTreeGood(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);


        return root;
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tempLeft = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tempLeft);
        return root;
    }


    public static TreeNode invertTreeBad(TreeNode root) {
        if(root == null)
            return null;

        // Special case
       /* if(root.left == null && root.right != null){
            root.left = new TreeNode(null);
            return root;
        }
        if(root.left != null && root.right == null){
            root.right = null;
            return root;
        }*/

        TreeNode temp = root;

        ArrayList<Integer> nodeValues = BSF(temp);

        TreeNode newHead = new TreeNode(root.val);

        for(int i = 1; i < nodeValues.size(); i++) {
            int newVal = nodeValues.get(i);
            insertInverted(newVal, newHead);
        }
        return newHead;
    }

    private static TreeNode createTree(int [] nums){
        if(nums == null || nums.length == 0) return null;
        TreeNode head = new TreeNode(nums[0]);
        TreeNode temp = head;

        for(int i = 0; i < nums.length; i++){
            insert(nums[i], head);
//            TreeNode newNode = new TreeNode(nums[i]);
        }
        return head;
    }

    private static boolean insert(int val, TreeNode head){
        TreeNode temp = head;
        TreeNode newNode = new TreeNode(val);
        while(true){
            if(newNode.val == temp.val) return false;
            //left
            if(newNode.val < temp.val){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }else{
                    temp = temp.left;
                }
            }else{ // right
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }else{
                    temp = temp.right;
                }
            }
        }
    }

    private static boolean insertInverted(int val, TreeNode head){
        TreeNode temp = head;
        TreeNode newNode = new TreeNode(val);
        while(true){
            if(newNode.val == temp.val) return false;
            //left
            if(newNode.val > temp.val){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }else{
                    temp = temp.left;
                }
            }else{ // right
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }else{
                    temp = temp.right;
                }
            }
        }
    }

    private static ArrayList<Integer> BSF(TreeNode head){
        if(head == null) return null;
        TreeNode currentNode = head;
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(currentNode);

        while(nodes.size() > 0){
            currentNode = nodes.remove();
            result.add(currentNode.val);
            if(currentNode.left != null){
                nodes.add(currentNode.left);
            }
            if(currentNode.right != null){
                nodes.add(currentNode.right);
            }
        }
        return result;
    }





}
