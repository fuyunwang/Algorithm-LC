package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1252
 * @Author fyw
 * @Date 2022/11/17 21:09
 * @Description 奇数值单元格的数目
 * 对于单元格而言，其值受到行列影响
 * 行奇*列偶+列奇*行偶
 */
public class Code1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row=new int[m];
        int[] col=new int[n];
        for (int[] indice:indices){
            row[indice[0]]++;
            col[indice[1]]++;
        }
        int hangou=0;
        int lieou=0;
        for (int i = 0; i < m; i++) {
            if (row[i]%2==0)
                hangou++;
        }
        for (int j=0;j<n;j++){
            if (col[j]%2==0){
                lieou++;
            }
        }
        return hangou*(n-lieou)+lieou*(m-hangou);
    }
}
