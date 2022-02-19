package com.gopher.leetcode.order.or900;

/**
 * @Title Code997
 * @Author fyw
 * @Date 2022/2/9 14:51
 * @Description: 找到小镇的法官
 */
public class Code997 {
    public int findJudge(int n, int[][] trust) {
        int[] a=new int[n+1];// 入度矩阵
        int[] b=new int[n+1];// 出度矩阵
        for (int[] t:trust){
            a[t[1]]++;
            b[t[0]]++;
        }
        int res=-1;
        for (int i = 1; i <= n; i++) {
            if (a[i]==n-1&&b[i]==0){
                if (res!=-1)
                    return -1;
                res=i;
            }
        }
        return res;
    }
}
