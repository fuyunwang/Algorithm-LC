package com.gopher.leetcode.order.or1800;

/**
 * @Title Code1863
 * @Author fyw
 * @Date 2022/2/8 11:13
 * @Description: 找出所有子集的异或总和再求和
 */
public class Code1863 {
    int res=0;
    public int subsetXORSum(int[] nums) {
        if (nums.length==1)
            return nums[0];
        backtrack(nums,0,0);
        return res;
    }
    void backtrack(int[] nums,int state,int index){
        if (index==nums.length){
            res+=state;
            return;
        }
        backtrack(nums,state^nums[index],index+1);
        backtrack(nums,state,index+1);
    }
}
