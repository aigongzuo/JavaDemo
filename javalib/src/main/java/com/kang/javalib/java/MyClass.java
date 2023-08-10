package com.kang.javalib.java;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyClass {
    //    static int[] array = {-2, 0, 1, 2, 3, 4, 5, 7};
    static int[] array = {2, 3, 4, 5, 7, -2, 0, 1};
    static int target = 5;

    public static void main(String[] args) {
//        sortOne(array);
        System.out.println(Arrays.toString(array));
//        for (int i = 0; i < array.length; i++) {
//            System.out.println("search : array[" + i + "]:" + array[i]);
//            int searchNumber = target - array[i];
//            int search = search(array, 0, array.length - 1, searchNumber);
//            if (search == -1) {
//                System.out.println("未找到...");
//            } else {
//                System.out.println("找到 array[" + search + "]:" + array[search]);
//            }
//        }

//        searchTwoNumber(0, array.length - 1);
        System.out.println("OVER!!!");
    }




    //比较排序
    private static void sortOne(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }


    //交换
    private static void swap(int[] array, int i, int j) {
        int cache = array[i];
        array[i] = array[j];
        array[j] = cache;
    }

    //双指针
    static void searchTwoNumber(int startIndex, int endIndex) {
        if (startIndex >= array.length || endIndex < 0) {
            return;
        }
        if (array[startIndex] + array[endIndex] == target) {
            System.out.println("array[" + startIndex + "]" + array[startIndex] + ",array[" + endIndex + "]" + array[endIndex]);
            searchTwoNumber(startIndex, --endIndex);
        } else if (array[startIndex] + array[endIndex] > target) {
            searchTwoNumber(startIndex, --endIndex);
        } else if (array[startIndex] + array[endIndex] < target) {
            searchTwoNumber(++startIndex, endIndex);
        }
    }

    static ReentrantLock reentrantLock ;
    //二分查找
    static int search(int[] array, int startIndex, int endIndex, int searchNumber) {
        int returnIndex = -1;
        if (startIndex > endIndex) {
            return -1;
        }
        int center = (startIndex + endIndex) / 2;
        if (array[center] == searchNumber) {
            return center;
        } else if (array[center] > searchNumber) {
            returnIndex = search(array, startIndex, --center, searchNumber);
        } else if (array[center] < searchNumber) {
            returnIndex = search(array, ++center, endIndex, searchNumber);
        }
        return returnIndex;
    }
}