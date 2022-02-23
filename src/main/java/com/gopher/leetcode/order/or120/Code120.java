package com.gopher.leetcode.order.or120;

import java.util.List;

/**
 * @Title Code120
 * @Author fyw
 * @Date 2022-02-23 11:05
 * @Description 三角形最小路径和
 * 从上到下考虑对于边界问题需要特判比较繁琐，故而采用从下到上考虑
 */
public class Code120 {
    // f[i][j] 从下到上走到[i,j]的路径集合，属性是最大值
    // 状态计算：考虑集合划分的最后一个选择，可能从左边上来也可能从右边上来，取两种情况最大值
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--){
            for (int j = 0; j <= triangle.get(i).size() - 1; j++){
                triangle.get(i).set(j, Math.min(triangle.get(i + 1).get(j),
                        triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}
