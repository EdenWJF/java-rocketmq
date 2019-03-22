package com.jinfour.rocketmq.algorithm;

import java.awt.*;

public class Reverse_linked_list {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode reverseList1(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        head.next = newHead;
        newHead = head;
        head = head.next;
        return reverseList1(head, newHead);
    }

    public static void main(String[] args){
        
    }
}
