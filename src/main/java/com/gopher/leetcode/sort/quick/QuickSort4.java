package com.gopher.leetcode.sort.quick;

/**
 * @Title QuickSort4
 * @Author fyw
 * @Date 2022/2/2 17:20
 * @Description: 快排查找第K大元素
 */
public class QuickSort4 {
    int n;
    int[] A=new int[n];
    public int quickSort(int l, int r, int k){
        if(l >= r) return A[k];

        int x = A[l], i = l-1, j = r+1;
        while(i < j) {
            do i++; while(A[i] < x);
            do j--; while(A[j] > x);
            if(i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        if(k <= j) return quickSort(l, j, k);
        else return quickSort(j+1, r, k);
    }

}
