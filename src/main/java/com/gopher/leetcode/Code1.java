package com.gopher.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code1
 * @Author fyw
 * @Date 2022/1/20 19:13
 * @Description: 两数之和
 */
public class Code1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])&&map.get(target-nums[i])!=i){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
