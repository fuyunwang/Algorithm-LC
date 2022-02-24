package com.gopher.leetcode.order.or900;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code904
 * @Author fyw
 * @Date 2022/2/9 14:06
 * @Description: 水果成篮
 * 长度最长最多包含两个不同元素的区间长度，
 * 滑动窗口 Code3
 */
public class Code904 {
    public int totalFruit(int[] fruits) {
        int left=0,right=0;
        Map<Integer,Integer> map=new HashMap<>();// 记录每个元素次数
        int res=0;
        while (right<fruits.length){
            int rcur=fruits[right++];
            map.put(rcur,map.getOrDefault(rcur,0)+1);
            while (map.size()>2){
                // 说明包含多个不同元素
                int lrur=fruits[left++];
                map.put(lrur,map.getOrDefault(lrur,0)-1);
                if (map.get(lrur)<=0){
                    map.remove(lrur);
                }
            }
            res=Math.max(res,right-left);
        }
        return res;
    }
}
