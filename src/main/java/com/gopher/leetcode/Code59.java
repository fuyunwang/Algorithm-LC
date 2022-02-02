package com.gopher.leetcode;

/**
 * @Title Code59
 * @Author fyw
 * @Date 2022/2/2 16:52
 * @Description: 螺旋矩阵II
 */
public class Code59 {
    public int[][] generateMatrix(int n) {
        if (n<1){
            return new int[0][0];
        }
        // x和y是真正的坐标，a和b探测坐标，d方向在即将越界时更换
        int[][] res=new int[n][n];
        int[] dx=new int[]{0,1,0,-1};
        int[] dy=new int[]{1,0,-1,0};
        for (int i = 1,x=0,y=0,d=0; i <= n*n; i++) {
            res[x][y]=i;
            int a=x+dx[d];
            int b=y+dy[d];
            if (a<0||a>=n||b<0||b>=n||res[a][b]!=0){
                d = (d+1)%4;
                a=x+dx[d];
                b=y+dy[d];
            }
            x=a;
            y=b;
        }
        return res;
    }
}
