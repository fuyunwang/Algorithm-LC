package com.gopher.leetcode.order.or80;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code89
 * @Author fyw
 * @Date 2022/2/9 14:02
 * @Description: 格雷码
 */
public class Code89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        while (n-- != 0) {
            for (int i = res.size() - 1; i >= 0; i--) {
                int t = res.get(i);
                res.set(i, t << 1);
                res.add((t << 1) + 1);
            }
        }
        return res;
    }
}
