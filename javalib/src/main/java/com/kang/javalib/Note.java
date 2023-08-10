package com.kang.javalib;

public class Note {

    public Note(int value) {
        this.value = value;
    }

    public int value;
    public Note left;
    public Note right;
}
