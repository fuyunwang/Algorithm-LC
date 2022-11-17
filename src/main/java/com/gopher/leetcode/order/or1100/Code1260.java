package com.gopher.leetcode.order.or1100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code1260
 * @Author fyw
 * @Date 2022/11/17 21:31
 * @Description 二维网格迁移
 * 类似之前翻转字符串的题目，进行三次reverse即可
 */
public class Code1260 {
    int m;
    int n;
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        this.m=grid.length;
        this.n=grid[0].length;
        k%=n*m;
        List<List<Integer>> ans=new ArrayList<>();
        reverse(grid,0,n*m);
        reverse(grid,0,k);
        reverse(grid,k,n*m);
        for (int i = 0; i < m; i++) {
            List<Integer> res=new ArrayList<>();
            for (int j = 0; j < n; j++) {
                res.add(grid[i][j]);
            }
            ans.add(res);
        }
        return ans;
    }
    void reverse(int[][] grid,int start,int end){
        for (int i = start,j=end-1; i < j; i++,j--) {
            int temp=grid[i/n][i%n];
            grid[i/n][i%n]=grid[j/n][j%n];
            grid[j/n][j%n]=temp;
        }
    }
}
