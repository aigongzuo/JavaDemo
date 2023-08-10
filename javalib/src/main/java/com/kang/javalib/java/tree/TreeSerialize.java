package com.kang.javalib.java.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeSerialize {
    public static ArrayDeque<Integer> qeue = new ArrayDeque<Integer>();

    static class TreeNote {
        public TreeNote(int value) {
            this.value = value;
        }

        int value;
        public TreeNote left;
        public TreeNote right;
    }

    public static void main(String[] args) {
        TreeNote tree1 = new TreeNote(5);
        TreeNote tree2 = new TreeNote(7);
        TreeNote tree3 = new TreeNote(3);
        TreeNote tree4 = new TreeNote(9);

        tree1.left = tree2;
        tree1.right = tree3;
        tree3.right = tree4;

        LinkedList<TreeNote> list = new LinkedList<>();
        list.offer(tree1);
        StringBuilder serializeStr = new StringBuilder();
        while (list.size() > 0) {
            TreeNote note = list.poll();
            if (note == null) {
                serializeStr.append("null").append(",");
                continue;
            }
            serializeStr.append(note.value).append(",");
            list.offer(note.left);
            list.offer(note.right);
        }
        System.out.println(serializeStr);
        String[] arr = serializeStr.toString().split(",");
//        System.out.println(Arrays.toString(arr));

        TreeNote[] treeNotes = new TreeNote[arr.length];

        for (int i = 0; i < treeNotes.length; i++) {
            if (!arr[i].toUpperCase().equals("NULL")) {
                treeNotes[i] = new TreeNote(Integer.parseInt(arr[i]));
            }
        }
        int j = 1;
        for (int i = 0; i < treeNotes.length; i++) {
            if (treeNotes[i] != null) {
                treeNotes[i].left = treeNotes[j++];
                treeNotes[i].right = treeNotes[j++];
            }
        }

        list = new LinkedList<>();
        list.offer(treeNotes[0]);
        serializeStr = new StringBuilder();
        while (list.size() > 0) {
            TreeNote note = list.poll();
            if (note == null) {
                serializeStr.append("null").append(",");
                continue;
            }
            serializeStr.append(note.value).append(",");
            list.offer(note.left);
            list.offer(note.right);
        }
        System.out.println(serializeStr);

//        serialize(treeNotes[0]);
//        System.out.println(qeue);
//        TreeNote treeNote = deserialize(qeue);
//        serialize(treeNote);
//        System.out.println(qeue);

        System.out.println("OVER!");
    }

    //序列化
    public static void serialize(TreeNote treeNote) {
        if (treeNote == null) {
            qeue.offer(null);
            return;
        }
        qeue.offer(treeNote.value);
        serialize(treeNote.left);
        serialize(treeNote.right);
    }

    //反序列化
    public static TreeNote deserialize(Queue<Integer> list) {
        Integer value = list.poll();
        if (value == null) {
            return null;
        }
        TreeNote note = new TreeNote(value);
        note.left = deserialize(list);
        note.right = deserialize(list);
        return note;
    }
}
