package com.kang.javalib.java.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class StringMaxLenth {
    static LinkedList list = new LinkedList();

    public static void main(String[] args) {
//        String s = " ";
//        int maxSize = lengthOfLongestSubstring(s);
        long reverseNumber=  reverse(1534236469);
        System.out.println("reverseNumber:" + reverseNumber);
    }

    public static long reverse(int x) {
        int FS = x<0?-1:1;
        x = Math.abs(x);
        long retNumber = 0;
        while(x>0) {
            retNumber = retNumber *10 + x%10;
            x = x/10;
        }
        return retNumber * FS;
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            String chatStr = s.substring(i, i + 1);
            while (list.contains(chatStr)) {
                list.pop();
            }
            list.offer(chatStr);
            max = Math.max(max, list.size());
        }
        return max;
    }
}
