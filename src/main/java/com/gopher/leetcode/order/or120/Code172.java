package com.gopher.leetcode.order.or120;

/**
 * @Title Code172
 * @Author fyw
 * @Date 2022-02-23 20:06
 * @Description 阶乘后的0
 * 1、假设 n!=kn!=k，k尾后又多少个0，取决于k能分解出多少个10，由于10 = 2 * 5，因此k尾后有多个10，取决于k有能分解出多少个2 和 5,
 * 2、假设 n!=k=2a×5b×....n!=k=2a×5b×....，则求k尾后有多少个10，等价于求Min(a, b);
 * 3、如何求2的次数a和5的次数b的值，P = 2 和P = 5，枚举质因子P，n!表示1 * 2 * 3... * n
 */
public class Code172 {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n != 0)
        {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
