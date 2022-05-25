package com.fuyunwang.bilibili.order.subarr;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code325
 * @Author fyw
 * @Date 2022-05-25 9:06
 * @Description 找到和等于k的最长连续子数组长度。如果不存在任意一个符合要求的子数组，则返回 0
 * 这个题目不单调，不能滑动窗口，只能前缀和
 */
public class Code325 {
    /**
     * 类似题目 523、525、560、862、930
     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);      // 初值
        int sum=0;
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (map.containsKey(sum-k)){
                res=Math.max(res,i-map.get(sum-k));
            }
            // 记录前缀和的最小位置，最开始出现的位置
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return res;
    }
}
