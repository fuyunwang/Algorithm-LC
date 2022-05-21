package com.fuyunwang.bilibili.order.math;

/**
 * @Title BitOpration
 * @Author fyw
 * @Date 2022/5/21 21:20
 * @Description: 位运算
 */
public class BitOperation {
    static class Code461{
        public int hammingDistance(int x, int y) {
            int res=0;
            while (x!=0||y!=0){
                res+=(x&1)^(y&1);   // 最后一位的异或
                x>>=1;
                y>>=1;
            }
            return res;
        }
    }
}
