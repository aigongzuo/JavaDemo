package com.kang.javalib.java.link;

import java.util.Arrays;

public class TowLinkNumberPlus {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        TowLinkNumberPlus towLinkNumberPlus = new TowLinkNumberPlus();
        towLinkNumberPlus.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        printNote(l1);
        System.out.println("");
        printNote(reverseNoteList(null, l1));
//        int number = noteToNumber(l1);
//        System.out.println(number);
//        printNote(numberToNote(number));


//        System.out.println(noteToNumber(l2));
//        int sum = noteToNumber(l1) + noteToNumber(l2);
//        ListNode l3 = numberToNote(sum);
//        System.out.println(noteToNumber(l3));
        return l1;
    }

    void printNote(ListNode l1) {
        System.out.print(l1.val + ",");
        if (l1.next != null) {
            printNote(l1.next);
        }
    }

    int noteToNumber(ListNode l1) {
        String numberStr = String.valueOf(l1.val);
        if (l1.next != null) {
            numberStr = noteToNumber(l1.next) + numberStr;
        }
        return Integer.parseInt(numberStr);
    }

    ListNode numberToNote(int number) {
        int lastNumber = number % 10;
        number = number / 10;
        ListNode listNode = new ListNode(lastNumber);
        if (number > 0) {
            listNode.next = numberToNote(number);
        }
        return listNode;
    }


    ListNode reverseNoteList(ListNode preNote, ListNode currentNote) {
        ListNode returnNote = currentNote;

        ListNode cacheNextNote = currentNote.next;
        currentNote.next = preNote;

        if (cacheNextNote != null) {
            returnNote = reverseNoteList(currentNote, cacheNextNote);
        }
        return returnNote;
    }
}
