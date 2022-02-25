package com.gopher.leetcode.order.or500;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code525
 * @Author fyw
 * @Date 2022/2/9 14:44
 * @Description: 连续数组
 */
public class Code525 {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();// key是1的个数减去0的个数，value是当前索引
        // 前缀和思想，始终保存前k个数中1的个数减去0的个数
        int one=0,zero=0;
        int res=0;
        map.put(0,0);
        for (int i = 1; i <= nums.length; i++) {
            int cur=nums[i-1];
            if (cur==0){
                zero++;
            }else{
                one++;
            }
            int s=one-zero;
            if (map.containsKey(s)){
                res=Math.max(res,i-map.get(s));
            }else{
                map.put(s,i);
            }
        }
        return res;
    }
}
