package com.gopher.leetcode.order.or500;

import java.util.Arrays;

/**
 * @Title Code593
 * @Author fyw
 * @Date 2022/2/7 18:11
 * @Description: 有效的正方形
 * 主要是根据四个坐标算出6条边，其中较短的四条边相等且较长的两条边相等则说明是有效正方形
 */
public class Code593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p={p1,p2,p3,p4};
        int[] dist=new int[6];
        int index=0;
        for (int i = 0; i < p.length-1; i++) {
            for (int j = i+1; j < p.length; j++) {
                dist[index++]=getDist(p[i],p[j]);       // 计算6种距离
            }
        }
        Arrays.sort(dist);
        if (dist[0]==0)
            return false;
        return dist[0]==dist[1]&&dist[0]==dist[2]&&dist[0]==dist[3]&&dist[4]==dist[5];
    }
    // 定义计算点距离的函数
    public int getDist(int[] p1,int[] p2){
        int x1=p1[0],x2=p2[0],y1=p1[1],y2=p2[1];
        return (int) (Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }
}
