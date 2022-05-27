package com.fuyunwang.bilibili.order.subarr;

import java.util.HashMap;

/**
 * @Title Code992
 * @Author fyw
 * @Date 2022-05-25 9:09
 * @Description K个不同整数的子数组
 * 一个窗口内正好有K个不同的整数称作好的子数组，求所有好的子数组的个数
 * 滑动窗口
 */
public class Code992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map1=new HashMap<>();  // 记录元素和出现的次数
        HashMap<Integer,Integer> map2=new HashMap<>();
        int res=0;
        for (int i = 0,right1=0,right2=0,cnt1=0,cnt2=0; i < n; i++) {
            if (map1.getOrDefault(nums[i],0)==0) cnt1++;
            map1.put(nums[i],map1.getOrDefault(nums[i],0)+1);
            while (cnt1>k){
                if (map1.get(nums[right1])==1)
                    cnt1--;
                map1.put(nums[right1],map1.getOrDefault(nums[right1],0)-1);
                right1++;
            }

            if (map2.getOrDefault(nums[i],0)==0) cnt2++;
            map2.put(nums[i],map2.getOrDefault(nums[i],0)+1);
            while (cnt2>k-1){
                if (map2.get(nums[right2])==1)
                    cnt2--;
                map2.put(nums[right2],map2.getOrDefault(nums[right2],0)-1);
                right2++;
            }
            res+=right2-right1;
        }
        return res;
    }
}
