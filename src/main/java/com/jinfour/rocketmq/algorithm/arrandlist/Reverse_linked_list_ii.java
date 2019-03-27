package com.jinfour.rocketmq.algorithm.arrandlist;

public class Reverse_linked_list_ii {

    public static ListNode reverseList(ListNode head, int m, int n) {
        ListNode tmp = new ListNode(0);

        tmp.next = head;
        ListNode root = tmp;
        //指向被反转部分的前一个节点
        for (int i = 0; i < m - 1; i++) {
            root = root.next;
        }
        ListNode pre = root.next;
        ListNode then = pre.next;

        while(n-m > 0) {
            //将root节点指向pre的下一个
            pre.next = then.next;
            then.next = root.next;//******
            root.next = then;//******顺序不能倒
            then = pre.next;
            m++;
        }

        return tmp.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;l2.next = l3;l3.next = l4;l4.next = l5;l5.next = l6;l6.next = null;
        ListNode res = reverseList(l1, 2, 4);
        for (int i = 0; i < 6; i++) {
            System.out.println(res.val);
            res = res.next;
        }

    }


}
