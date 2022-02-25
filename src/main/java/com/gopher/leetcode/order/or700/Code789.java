package com.gopher.leetcode.order.or700;

/**
 * @Title Code798
 * @Author fyw
 * @Date 2022/2/9 14:08
 * @Description: 逃脱阻碍者
 * 曼哈顿距离，割补法
 */
public class Code789 {
    int getDis(int a1,int b1,int a2,int b2){
        return Math.abs(a1-a2) + Math.abs(b1-b2);
    }

    public boolean escapeGhosts(int[][] ghosts, int[] t) {
        int dis = getDis(0,0,t[0],t[1]);
        for(int g[] : ghosts){
            int v = getDis(g[0],g[1],t[0],t[1]);
            if(v<=dis) return false;
        }
        return true;
    }
}
