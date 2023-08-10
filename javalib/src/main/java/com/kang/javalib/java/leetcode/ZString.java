package com.kang.javalib.java.leetcode;

import java.util.Arrays;

public class ZString {

    public static void main(String[] args) {
        String zStr = new ZString().convert("AB", 1);
        System.out.println("zStr:" + zStr);
    }

    public ZString() {
    }

    public String convert(String s, int numRows) {
        String[] array = new String[numRows];
        Arrays.fill(array, "");
        boolean isTopToBottom = true;
        int index = 0;
        while (s.length() > 0) {
            String str = s.substring(0, 1);
            s = s.substring(1, s.length());
            array[index] += str;
            if (numRows > 1) {
                if (index == numRows - 1) {
                    isTopToBottom = false;
                } else if (index == 0) {
                    isTopToBottom = true;
                }

                if (isTopToBottom) {
                    index++;
                } else {
                    index--;
                }
            }
        }


        String returnStr = "";
        for (int i = 0; i < array.length; i++) {
            returnStr += array[i];
        }
        return returnStr;
    }
}
