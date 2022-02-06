package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1748
 * @Author fyw
 * @Date 2022/2/6 10:28
 * @Description: 唯一元素和
 * 本题数组长度在[1,100],数组中每个元素范围在[1,100]。知道数据范围可以使用计数排序思路
 */
public class Code1748 {
    public int sumOfUnique(int[] nums) {
        int[] count=new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int res=0;
        for (int i = 0; i < count.length; i++) {
            if (count[i]==1){
                res+=i;
            }
        }
        return res;
    }
}
