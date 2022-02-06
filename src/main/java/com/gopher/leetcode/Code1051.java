package com.gopher.leetcode;

import java.util.Arrays;

/**
 * @Title Code1051
 * @Author fyw
 * @Date 2022/2/6 17:13
 * @Description:
 */
public class Code1051 {
    public int heightChecker(int[] heights) {
        int[] temp=heights.clone();
        Arrays.sort(temp);
        int res=0;
        for(int i=0;i<heights.length;i++){
            if(temp[i]!=heights[i]){
                res++;
            }
        }
        return res;
    }
}
