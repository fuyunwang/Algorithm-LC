package com.gopher.leetcode.order.or200;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code228
 * @Author fyw
 * @Date 2022-02-24 9:08
 * @Description 汇总区间
 * 双指针
 */
public class Code228 {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<String>();
        for(int i = 0;i < n;i ++)
        {
            int j = i + 1;
            while(j < n && nums[j] == nums[j - 1] + 1) j ++;
            int a = nums[i], b = nums[j - 1];
            if(i == j - 1) ans.add("" + a);
            else ans.add(a + "->" + b);
            i = j - 1;
        }
        return ans;
    }
}
