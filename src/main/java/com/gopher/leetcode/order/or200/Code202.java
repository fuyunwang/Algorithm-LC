package com.gopher.leetcode.order.or200;

/**
 * @Title Code202
 * @Author fyw
 * @Date 2022/2/9 13:51
 * @Description: 快乐数
 * 类似环形链表
 */
public class Code202 {
    int get(int x) {
        int res = 0;
        while (x!=0) {
            res += (x % 10) * (x % 10);
            x /= 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        int fast = get(n), slow = n;
        while (fast != slow) {
            fast = get(get(fast));
            slow = get(slow);
        }
        return fast == 1;
    }
}
