package com.gopher.leetcode.types.doublepointer;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-01 21:44
 * @Description
 */
public class Template1 {
    static class Code11{

    }
    static class Code1089{
        // 有点插排的思想
        public void duplicateZeros(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]==0){
                    for (int j = arr.length-1; j >i ; j--) {
                        arr[j]=arr[j-1];
                    }
                    i++;
                }
            }
        }
    }
}
