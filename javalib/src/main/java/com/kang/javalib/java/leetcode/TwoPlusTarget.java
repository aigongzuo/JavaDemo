package com.kang.javalib.java.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TwoPlusTarget {

    public int[] twoSum(int[] nums, int target) {
        int[] returnArr = {0, 0};
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                returnArr[0] = left;
                returnArr[1] = right;
                break;
            }
        }
        return returnArr;
    }

    public static void main(String[] args) {
        TwoPlusTarget twoPlusTarget = new TwoPlusTarget();
        int[] result = twoPlusTarget.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(result));
    }
}
