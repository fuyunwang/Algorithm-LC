package com.gopher.leetcode.order.or100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code118
 * @Author fyw
 * @Date 2022/2/9 12:27
 * @Description: 杨辉三角
 * 递推
 */
public class Code118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> line=new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0||j==i)
                    line.add(1);
                else
                    line.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            res.add(line);
        }
        return res;
    }
}
