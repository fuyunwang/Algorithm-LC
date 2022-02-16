package com.gopher.leetcode.order.or200;

/**
 * @Title Code289
 * @Author fyw
 * @Date 2022/2/16 19:38
 * @Description: 要求从一个状态原地变换成另外一个状态
 * 矩阵的元素值只是 0 和 1。那么可以利用int 32位的倒数第二位存状态，然后移到最后一位即可
 */
public class Code289 {
    public void gameOfLife(int[][] board) {
        int m=board.length,n=board[0].length;
        int dx[]={-1,-1,-1,0,0,1,1,1},dy[]={-1,0,1,-1,1,-1,0,1};
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                int cnt=0;
                for(int k=0;k<8;k++){
                    int u=i+dx[k],v=j+dy[k];
                    if(u<0 || u>=m || v<0 || v>=n) continue;
                    if((board[u][v]&1)==1) cnt++;
                }
                int next=0;
                if(board[i][j]==1 && (cnt==2 || cnt==3)) next=1;// 第二种情况
                if(board[i][j]==0 && cnt==3) next=1;    //第四种情况
                // 第一种和第三种情况next为0
                if(next==1) board[i][j]|=next<<1;  // 存到倒数第二位
            }
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) board[i][j]>>=1;   // 最后倒数第二位存到倒数第一位
    }
}
