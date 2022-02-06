package com.gopher.leetcode.order.or1000;

/**
 * @Title Code1089
 * @Author fyw
 * @Date 2022/2/6 14:04
 * @Description: 覆写0
 * 类似插入排序
 */
public class Code1089 {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0){
                for (int j = arr.length-1; j>i ; j--) {
                    arr[j]=arr[j-1];
                }
                i++;
            }
        }
    }
}
