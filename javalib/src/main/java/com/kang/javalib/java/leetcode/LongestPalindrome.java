package com.kang.javalib.java.leetcode;

import java.util.ArrayList;

public class LongestPalindrome {
    public static void main(String[] args) {
        String max = new LongestPalindrome().longestPalindrome("babad");
        System.out.println("MaxStr:" + max);
    }


    ArrayList<String> strArray = new ArrayList();

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            int endIndex = i;
            if ((endIndex + 1 < s.length()) && s.substring(i, endIndex + 1).equals(s.substring(i + 1, endIndex + 2))) {
                endIndex++;
            }
            searchStrByIndex(s, i, endIndex);
        }
        String retStr = "";
        for (String str : strArray) {
            if (str.length() > retStr.length()) {
                retStr = str;
            }
        }
        return retStr;
    }

    void searchStrByIndex(String s, int startIndex, int endIndex) {
        char[] chatArray = s.toCharArray();
        while ((startIndex - 1 >= 0)
                && (endIndex + 1 < s.length())
                && chatArray[startIndex - 1] == chatArray[endIndex + 1]) {
            startIndex--;
            endIndex++;
        }
        if (startIndex != endIndex) {
            strArray.add(s.substring(startIndex, endIndex+1));
        }
    }
}
