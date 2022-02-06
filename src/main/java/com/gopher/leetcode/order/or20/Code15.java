package com.gopher.leetcode.order.or20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title Code15
 * @Author fyw
 * @Date 2022/1/22 13:55
 * @Description: 三数之和
 */
public class Code15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1])continue;
            for (int j=i+1,k=nums.length-1;j<k;j++){
                if (j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                while (j<k-1&&nums[i]+nums[j]+nums[k-1]>=0)
                    k--;
                if (nums[i]+nums[j]+nums[k]==0){
                    result.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                }
            }
        }
        return result;
    }
}
