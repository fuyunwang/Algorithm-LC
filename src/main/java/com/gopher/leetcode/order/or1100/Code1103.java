package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1103
 * @Author fyw
 * @Date 2022/1/28 18:54
 * @Description: 分糖果II
 */
public class Code1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res=new int[num_people];
        for (int i = 0,j=1; candies!=0; i=(i+1)%num_people,j++) { // i表示第i轮，j表示当前应该分的糖果
            res[i]+=Math.min(j,candies);
            candies-=Math.min(j,candies);
        }
        return res;
    }
}
