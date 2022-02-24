package com.gopher.leetcode.order.or300;

import java.util.Random;

/**
 * @Title Code384
 * @Author fyw
 * @Date 2022/2/9 13:47
 * @Description: 打乱数组
 * 等概率返回随机一个排列
 */
public class Code384 {
    class Solution {
        int a[];
        public Solution(int[] nums) {
            this.a=nums;
        }

        public int[] reset() {
            return a;
        }

        public int[] shuffle() {
            int b[]=new int[a.length];
            for(int i=0;i<b.length;i++) b[i]=a[i];
            Random r=new Random();
            // 考虑第一个位置，可以是任何一个元素，所以可以任意随机交换一个元素
            for(int i=0;i<b.length;i++){
                int j=i+r.nextInt(b.length-i);
                int temp=b[j];
                b[j]=b[i];
                b[i]=temp;
            }
            return b;
        }

    }
}
