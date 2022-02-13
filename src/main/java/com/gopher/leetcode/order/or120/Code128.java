package com.gopher.leetcode.order.or120;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code128
 * @Author fyw
 * @Date 2022/2/3 20:59
 * @Description: 最长连续序列
 */
public class Code128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],1);
        }
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]-1)){
                int temp=nums[i];
                while (map.containsKey(temp+1)){
                    temp++;
                }
                res=Math.max(res,temp-nums[i]+1);
            }
        }
        return res;
    }
}
