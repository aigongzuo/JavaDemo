package com.kang.javalib.java.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class QuickSort {
    static int[] array = {1, 1, 2, 2, 0, 0, 0, 1};

//    public static void main(String[] args) {
//        int l = 0;
//        int r = array.length - 1;
//        int i = 0;
//        while (i <= r) {
//            if (array[i] == 0) {
//                swap(array, i, l);
//                l++;
//            } else if (array[i] == 2) {
//                swap(array, i, r);
//                r--;
//                i--;
//            }
//            i++;
//        }
//        System.out.println(Arrays.toString(array));
//        System.out.println("OVER");
//    }


    public static void main(String[] args) {
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        System.out.println("OVER!!!");

//        ArrayList<Integer> array1 = new ArrayList();
//        for (int number: array) {
//            array1.add(number);
//        }
//        array1.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer integer, Integer t1) {
//                return integer - t1;
//            }
//        });
//        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int centerIndex = leftSmallRightBigSort(array, left, right);
        quickSort(array, left, centerIndex - 1);
        quickSort(array, centerIndex + 1, right);
    }

    private static int leftSmallRightBigSort(int[] array, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        int centerIndex = left;

        while (leftIndex < rightIndex) {
            while (array[centerIndex] <= array[rightIndex] && leftIndex < rightIndex) {
                rightIndex--;
            }
            while (array[centerIndex] >= array[leftIndex] && leftIndex < rightIndex) {
                leftIndex++;
            }
            if (leftIndex < rightIndex) {
                swap(array, leftIndex, rightIndex);
            }
        }
        swap(array, centerIndex, leftIndex);
        return leftIndex;
    }

//
//    private static void quickSort(int[] array, int startIndex, int endIndex) {
//        if (startIndex >= endIndex) {
//            return;
//        }
//        int baseIndex = changeLeftRightArray(array, startIndex, endIndex);
//        //左边排序
//        quickSort(array, startIndex, baseIndex - 1);
//        //右边排序
//        quickSort(array, baseIndex + 1, endIndex);
//    }
//
//    private static int changeLeftRightArray(int[] array, int startIndex, int endIndex) {
//        int baseIndex = startIndex;
//        int left = startIndex;
//        int right = endIndex;
//
//        while (left < right) {
//            while (array[baseIndex] < array[right] && left < right) {
//                right--;
//            }
//            while (array[baseIndex] > array[left] && left < right) {
//                left++;
//            }
//            if (left < right) {
//                swap(array, left, right);
//            }
//        }
//        swap(array, baseIndex, left);
//        baseIndex = left;
//        return baseIndex;
//    }

    //交换
    private static void swap(int[] array, int i, int j) {
        int cache = array[i];
        array[i] = array[j];
        array[j] = cache;
    }

}
