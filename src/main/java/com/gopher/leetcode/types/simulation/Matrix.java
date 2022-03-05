package com.gopher.leetcode.types.simulation;

/**
 * @Title Matrix
 * @Author fyw
 * @Date 2022-03-04 21:16
 * @Description
 */
public class Matrix {
    static class Code48{

    }
    static class Code1886{

    }
    static class Code1103{
        public int[] distributeCandies(int candies, int num_people) {
            int[] res=new int[num_people];
            for (int i = 0, j=1; candies!=0; i=(i+1)%num_people,j++) {
                int cur=Math.min(candies,j);//当前应该分的糖果
                res[i]+=cur;
                candies-=cur;
            }
            return res;
        }
    }
}
