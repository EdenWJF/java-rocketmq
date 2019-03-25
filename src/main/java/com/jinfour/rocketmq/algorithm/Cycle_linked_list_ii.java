package com.jinfour.rocketmq.algorithm;

import java.util.HashSet;

public class Cycle_linked_list_ii {

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet();
        ListNode tmp = head;
        while(tmp != null) {
            if (!set.contains(tmp)) {
                set.add(tmp);
                tmp = tmp.next;
            } else {
                return tmp;
            }

        }
        return null;
    }


    public static void main(String[] args) {

    }
}
