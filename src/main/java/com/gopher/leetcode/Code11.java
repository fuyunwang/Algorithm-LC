package com.gopher.leetcode;

/**
 * @Title Code11
 * @Author fyw
 * @Date 2022/1/22 11:26
 * @Description: 盛水最多的容器
 */
public class Code11 {
    public int maxArea(int[] height) {
        int result=0;
        for(int i=0 , j=height.length - 1;i<j;){
            result=Math.max(result,Math.min(height[i],height[j])*(j-i));
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return result;
    }
}
