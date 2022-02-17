package com.gopher.leetcode.order.or700;

/**
 * @Title Code780
 * @Author fyw
 * @Date 2022/2/17 12:25
 * @Description: 到达终点
 * 反向考虑 从终点到起点
 */
public class Code780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty) break;
            if (tx > ty) {
                if (ty > sy) tx %= ty;
                else return (tx - sx) % ty == 0;
            } else {
                if (tx > sx) ty %= tx;
                else return (ty - sy) % tx == 0;
            }
        }
        return (tx == sx && ty == sy);
    }

}
