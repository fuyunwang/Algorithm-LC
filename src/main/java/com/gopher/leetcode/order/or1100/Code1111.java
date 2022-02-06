package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1111
 * @Author fyw
 * @Date 2022/2/4 12:38
 * @Description: 有效括号的嵌套深度
 * 位运算 & 1 相当于 % 2
 *
 * 深度最小：max(depth(A), depth(B)) 的可能取值最小。 所以目标是将每一个括号按照奇偶来分配给字符串A和B
 */
public class Code1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int len=seq.length();
        int[] depth=new int[len];
        for (int i = 0; i < len; i++) {
            depth[i]=seq.charAt(i)=='('?i&1:(i+1)%2;
        }
        return depth;
    }
}
