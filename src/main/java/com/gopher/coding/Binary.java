package com.gopher.coding;

/**
 * @Title Binary
 * @Author fyw
 * @Date 2022/2/20 18:13
 * @Description:
 */
public class Binary {
    public static void main(String[] args) {
        int n=10;
        // 输出n的二进制表示
        for (int i = 3; i >=0 ; i--) {
            System.out.print(n>>i&1);
        }
        System.out.println();
        // x&-x可以返回最后一个1，比如
        int x = n & -n;
        for (int i = 15; i >= 0 ; i--) {
            System.out.print(x>>i&1);
        }
    }
}
