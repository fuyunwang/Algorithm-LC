package com.gopher.leetcode.order.or300;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code347
 * @Author fyw
 * @Date 2022/2/9 12:37
 * @Description: 前K个高频元素
 * 计数排序
 * 类似 剑指 Offer 03. 数组中重复的数字。
 */
public class Code347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //统计每个元素出现的次数
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int n=nums.length;
        // 最多能够出现的次数也就是n，声明相应大小的数组。值为次数，索引为值
        int[] temp=new int[n+1];
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            temp[entry.getValue()]++;
        }
        //寻找分界点：从后往前遍历，直到下标对应的次数凑够k
        int index=0,end=nums.length;
        while (index<k){
            index+=temp[end--];
        }

        int[] res = new int[k];
        int i = 0;
        //遍历哈希表，如果次数超过n，记录答案
        for(Integer t: map.keySet()){
            if(map.get(t) > end){
                res[i++] = t;
            }
        }
        return res;
    }
}
