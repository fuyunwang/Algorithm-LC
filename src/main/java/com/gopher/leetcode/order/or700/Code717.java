package com.gopher.leetcode.order.or700;

/**
 * @Title Code717
 * @Author fyw
 * @Date 2022/2/20 11:45
 * @Description: 1比特与2比特字符
 */
public class Code717 {
    // 编码的解码，注意顺序从前往后肯定是以1开头，所以每开头1就走两位，否则1位。
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (i==bits.length-1&&bits[i]==0)
                return true;
            if (bits[i]==1)
                i++;
        }
        return false;
    }
}
