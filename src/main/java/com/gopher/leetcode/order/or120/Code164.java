package com.gopher.leetcode.order.or120;

/**
 * @Title Code164
 * @Author fyw
 * @Date 2022/2/9 14:11
 * @Description: 最大间距
 * 排序之后相邻元素的最大值，桶排序
 */
public class Code164 {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        int MIN = Integer.MAX_VALUE, MAX = Integer.MIN_VALUE;
        for(int i = 0;i < n;i ++)
        {
            MIN = Math.min(MIN, nums[i]);
            MAX = Math.max(MAX, nums[i]);
        }
        if(n < 2 || MIN == MAX) return 0;

        Range[] r = new Range[n - 1];
        for(int i = 0;i < n - 1;i ++) r[i] = new Range();

        for(int i = 0;i < n;i ++)
        {
            int t = nums[i];
            if(t == MIN) continue;
            int len = (MAX - MIN + n - 2) / (n - 1);
            int k = (t - MIN - 1) / len;
            r[k].minv = Math.min(r[k].minv, t);
            r[k].maxv = Math.max(r[k].maxv, t);
            r[k].used = true;
        }

        int res = 0;
        for(int i = 0, last = MIN;i < n - 1;i ++)
        {
            if(r[i].used)
            {
                res = Math.max(res, r[i].minv - last);
                last = r[i].maxv;
            }
        }

        return res;
    }
    class Range
    {
        int minv;
        int maxv;
        boolean used;
        Range()
        {
            minv = Integer.MAX_VALUE;
            maxv = Integer.MIN_VALUE;
            used = false;
        }
    }
}
