package com.gopher.leetcode.order.or200;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code229
 * @Author fyw
 * @Date 2022/2/9 13:48
 * @Description: 众数
 * Code169，摩尔投票算法
 */
public class Code229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int n = nums.length;
        int r1 = 0, r2 = 0, c1 = 0, c2 = 0;
        for(int i = 0;i < n;i ++) { // 不论是何种情况始终是2个非众数消耗一个众数
            if(c1 != 0 && nums[i] == r1) c1 ++;
            else if(c2 != 0 && nums[i] == r2) c2 ++;
            else if(c1 == 0) {
                r1 = nums[i];
                c1 ++;
            }
            else if(c2 == 0) {
                r2 = nums[i];
                c2 ++;
            }
            else {
                c1 --;
                c2 --;
            }
        }
        // 众数可能有多个
        c1 = 0;
        c2 = 0;
        for(int i = 0;i < n;i ++)
        {
            if(nums[i] == r1) c1 ++;
            else if(nums[i] == r2) c2 ++;
        }
        if(c1 > n / 3) res.add(r1);
        if(c2 > n / 3) res.add(r2);
        return res;
    }
}
