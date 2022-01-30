package com.gopher.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code747
 * @Author fyw
 * @Date 2022/1/30 17:33
 * @Description:
 */
public class Code747 {
    public int dominantIndex(int[] nums) {
        // 声明两个map，一个保存索引映射用于结果返回，一个存储当前元素的2倍进行判别
        Map<Integer,Integer> doubleVal=new HashMap<>();
        Map<Integer,Integer> index=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            doubleVal.put(nums[i],2*nums[i]);
            index.put(nums[i],i);
            max=Math.max(max,nums[i]);
        }
        for (Integer value:doubleVal.values()) {
            if (max<value&&max*2!=value){
                return -1;
            }
        }
        return index.get(max);
    }
    // 双百做法，这个类似于递增的三元子序列
    public int dominantIndex1(int[] nums) {
        int max=Integer.MIN_VALUE,less=max,idx=0;
        // 记录最大值以及次大值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>max){
                less=max;
                max=nums[i];
                idx=i;
            } else if (nums[i] > less) {
                less=nums[i];
            }
        }
        return max>=2*less?idx:-1;
    }
}
