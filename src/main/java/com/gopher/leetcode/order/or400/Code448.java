package com.gopher.leetcode.order.or400;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code448
 * @Author fyw
 * @Date 2022/2/9 14:46
 * @Description: 找到所有数组中消失的数字
 */
public class Code448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 还是采用442题标记的思想
        for (int X: nums){
            X=Math.abs(X);
            if (nums[X-1]>0) nums[X-1]*=-1;
        }
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0)
                res.add(i+1);
        }
        return res;
    }
}
