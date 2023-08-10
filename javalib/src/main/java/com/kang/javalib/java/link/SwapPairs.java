package com.kang.javalib.java.link;

import com.kang.javalib.java.link.ListNode;

//https://leetcode.cn/problems/swap-nodes-in-pairs/
public class SwapPairs {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        SwapPairs swapPairs = new SwapPairs();
        swapPairs.printNote(node);
        System.out.println("");
        ListNode retNote = swapPairs.swapPairs(node);
        swapPairs.printNote(retNote);
    }

    void printNote(ListNode l1) {
        System.out.print(l1.val + ",");
        if (l1.next != null) {
            printNote(l1.next);
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode nextNote = head.next;
        head.next = swapPairs(nextNote.next);
        nextNote.next = head;
        return nextNote;
    }
}
