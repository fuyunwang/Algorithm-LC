package com.gopher.leetcode.order.or900;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title Code912
 * @Author fyw
 * @Date 2022/2/8 21:29
 * @Description: 三路快排
 */
public class Code912 {
    public int[] sortArray(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr,int L, int R){
        int less=L-1;
        int more=R;
        int cur=L;
        while (cur<more){
            if (arr[cur]<arr[R]){
                swap(arr,++less,cur++);
            }else if (arr[cur]>arr[R]){
                swap(arr,--more,cur);
            }else {
                cur++;
            }
        }
        swap(arr,more,R);
        return new int[]{less+1,more};
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
