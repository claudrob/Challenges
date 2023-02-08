package org.example.leetcode;

import org.example.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q101SymmetricTree {

    public static void main(String [] args){
        // Symmetric test
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        TreeNode leftSideLeft = new TreeNode(3);
        left.left = leftSideLeft;
        TreeNode leftSideRight = new TreeNode(4);
        left.right = leftSideRight;


        TreeNode rightSideLeft = new TreeNode(4);
        TreeNode rightSideRight = new TreeNode(3);
        right.right = rightSideRight;
        right.left = rightSideLeft;

        System.out.println("Result: " + isSymmetric(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);


    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if(left == null || right == null) {
            return false;
        }

        if(left.val != right.val) return false;

        if(!isSymmetric(left.left, right.right)) return false;

        if(!isSymmetric(left.right, right.left)) return false;


        return true;
    }

        public static boolean isSymmetricTemp(TreeNode root) {
            boolean result = false;

            TreeNode start = root;
            TreeNode leftSide = start.left;
            TreeNode rightSide = start.right;

            ArrayList<Integer> leftResults = new ArrayList<>();
            Queue<TreeNode> leftQueue = new LinkedList<>();

            leftQueue.add(leftSide);

            while(leftQueue.size() > 0){
                leftSide = leftQueue.remove();
                leftResults.add(leftSide.val);

                if(leftSide.left != null) {
                    leftQueue.add(leftSide.left);
                }else{
                    leftResults.add(null);
                }
                if(leftSide.right != null){
                    leftQueue.add(leftSide.right);
                }else{
                    leftResults.add(null);
                }

            }
            System.out.println(leftResults);

            return false;
        }

}
