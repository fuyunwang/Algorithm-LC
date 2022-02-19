package com.gopher.leetcode.order.or900;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Title Code969
 * @Author fyw
 * @Date 2022/2/19 13:14
 * @Description: 煎饼排序
 * 两次翻转并递归
 */
public class Code969 {
    List<Integer> res=new ArrayList<>();
    public List<Integer> pancakeSort(int[] arr) {
        if (arr.length==0){
            return Collections.emptyList();
        }
        sort(arr,arr.length);
        return res;
    }
    void sort(int[] arr,int n){
        if (n==1){
            return;
        }
        int maxIndex=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max<arr[i]){
                max=arr[i];
                maxIndex=i;
            }
        }
        reverse(arr,0,maxIndex);
        res.add(maxIndex+1);
        reverse(arr,0,n-1);
        res.add(n);
        sort(arr,n-1);
    }
    void reverse(int[] arr,int i,int j) {
        while (i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}
