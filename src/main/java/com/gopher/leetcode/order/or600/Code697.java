package com.gopher.leetcode.order.or600;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code697
 * @Author fyw
 * @Date 2022/11/17 20:12
 * @Description 数组的度
 * 计算众数并存开始位置和结束位置
 * 统计所有众数的长度最小者
 */
public class Code697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int maxCount=0;
        Map<Integer,Integer> firstPos=new HashMap<>();
        Map<Integer,Integer> lastPos=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            maxCount=Math.max(map.get(nums[i]),maxCount);
            if (!firstPos.containsKey(nums[i]))
                firstPos.put(nums[i],i);
            lastPos.put(nums[i],i);
        }
        int ans=nums.length;
        for (Integer key:map.keySet()){
            if (map.get(key)==maxCount){
                ans=Math.min(ans,lastPos.get(key)-firstPos.get(key)+1);
            }
        }
        return ans;
    }
}
