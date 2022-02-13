package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1295
 * @Author fyw
 * @Date 2022/2/13 19:46
 * @Description: 统计位数为偶数的数字
 */
public class Code1295 {
    public int findNumbers(int[] nums) {
        int res=0;
        for (int i:nums){
            int count=0;
            while (i>0){
                i/=10;
                count++;
            }
            res+=(count&1)==1?0:1;
        }
        return res;
    }
}
