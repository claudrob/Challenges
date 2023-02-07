package org.example.leetcode;

import org.example.leetcode.util.ListNode;

public class Q21MergeTwoSortedLists {

    public static void main(String [] args){
        ListNode head1 = new ListNode(-9);
        ListNode node2 = new ListNode(3);
        head1.next = node2;
//        ListNode node3 = new ListNode(4);
//        node2.next = node3;


        ListNode head2 = new ListNode(5);
        ListNode node12 = new ListNode(7);
        head2.next = node12;

//        ListNode node13 = new ListNode(4);
//        node12.next = node13;

        System.out.println("Input 1:  ");
        printLL(head1);
        System.out.println("Input 2:  ");
        printLL(head2);

        ListNode sortedListHead = mergeTwoLists(head1, head2);
        System.out.println("Sorted Result:  ");
        printLL(sortedListHead);



    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode tempHead = new ListNode(0);
        ListNode temp = tempHead;

        while(list1 != null && list2 != null){

            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }else{
                temp.next= list2;
                list2 = list2.next;
                temp = temp.next;
            }

        }
        while(list1 != null){
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }
        while(list2 != null){
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }
        return tempHead.next;

    }

    public static ListNode mergeTwoListsLong(ListNode list1, ListNode list2) {
        ListNode sortedHead = null;
        ListNode sortedTemp = null;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(sortedTemp == null){
                    sortedTemp = list1;
                    if(sortedHead == null) {
                        sortedHead = list1;
                    }
                }else{
                    sortedTemp.next = list1;
                    sortedTemp = sortedTemp.next;
                }
                list1 = list1.next;
            }else{
                if(sortedTemp == null){
                    sortedTemp = list2;
                    if(sortedHead == null) {
                        sortedHead = list2;
                    }
                }else{
                    sortedTemp.next = list2;
                    sortedTemp = sortedTemp.next;
                }
                list2 = list2.next;
            }
        }

        while(list1 != null){
            if(sortedTemp == null){
                sortedTemp = list1;
                if(sortedHead == null){
                    sortedHead = list1;
                }
            }else {
                sortedTemp.next = list1;
                sortedTemp = sortedTemp.next;
            }
            list1 = list1.next;
        }

        while(list2 != null){
            if(sortedTemp == null){
                sortedTemp = list2;
                if(sortedHead == null){
                    sortedHead = list2;
                }
            }else {
                sortedTemp.next = list2;
                sortedTemp = sortedTemp.next;
            }

            list2 = list2.next;
        }


        return sortedHead;

    }

    public static void printLL(ListNode head){

        while(head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }

}
