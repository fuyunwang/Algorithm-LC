package com.gopher.leetcode;

/**
 * @Title Code1103
 * @Author fyw
 * @Date 2022/1/28 18:54
 * @Description:
 */
public class Code1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res=new int[num_people];
        for (int i = 0,j=1; candies!=0; i=(i+1)%num_people,j++) {
            res[i]+=Math.min(j,candies);
            candies-=Math.min(j,candies);
        }
        return res;
    }
}
