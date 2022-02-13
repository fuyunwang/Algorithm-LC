package com.gopher.leetcode.order.or400;

/**
 * @Title Code498
 * @Author fyw
 * @Date 2022/2/2 17:14
 * @Description: 对角线遍历
 * 高频题目
 */
public class Code498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int n=mat.length;
        if (n==0){
            return new int[]{};
        }
        int m=mat[0].length;
        int[] res=new int[n*m];
        int x=0,y=0;
        for (int i = 0; i < n*m; i++) {
            res[i]=mat[x][y];
            if ((x+y)%2==0){
                // 说明此时是右上方向的遍历
                if (y==m-1){ // 注意一定先判断列，因为有可能此时到最后一列也是第一行，那么应该先按照列因为是从第一行过来的
                    // 由于即将左下，所以进行变换，观察规律发现列不变，行加1
                    x++;
                }else if (x==0){
                    // 由于即将左下，所以进行变换，观察规律发现行不变，列加1
                    y++;
                }else{
                    // 非边界情况，注意这样可以保证下次左下遍历会覆盖更多元素
                    x--;
                    y++;
                }
            }else{
                // 说明此时是左下方向的遍历
                if (x==n-1){
                    y++;
                }else if (y==0){
                    x++;
                }else{
                    y--;
                    x++;
                }
            }
        }
        return res;
    }
}
