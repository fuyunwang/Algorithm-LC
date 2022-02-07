package com.gopher.leetcode.order.or500;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code594
 * @Author fyw
 * @Date 2022/2/7 15:39
 * @Description: 最长和谐子序列
 * 借用两数之和的思路
 */
public class Code594 {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();//记录每个数字出现的次数
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int res=0;
        // 差值为1可以转换为直接查表
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if (map.containsKey(entry.getKey()-1)){
                res=Math.max(res,entry.getValue()+map.get(entry.getKey()-1));
            }
        }
        return res;
    }
}
