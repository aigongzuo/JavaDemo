package com.kang.javalib;

import java.util.LinkedList;

public class Demo {
    static LinkedList<Note> list = new LinkedList<>();
    public static void main(String[] args) {
        Note note = new Note(1);
        note.left = new Note(2);
        note.right = new Note(3);
        printAllNote(note);
        String name = null;
        System.out.println(name +"OVER!!!");
    }

    static void printAllNote(Note note) {
        list.offer(note);
        while (list.size()>0) {
            Note pNote = list.poll();
            if (pNote != null) {
                System.out.println(pNote.value);
                list.offer(pNote.left);
                list.offer(pNote.right);
            }
        }

    }

    //new Demo().serilaze(note);
//    public void printAllNoteByDeep(Note note) {
//        if (note == null) {
//            return;
//        }
//        System.out.println(note.value);
//        serilaze(note.left);
//        serilaze(note.right);
//    }
}
