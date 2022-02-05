package com.gopher.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code1072
 * @Author fyw
 * @Date 2022/2/5 20:36
 * @Description: 要求交换一些列之后实现全0或者全1，计算这些行数。注意全0的行取异或就是全1的行数反之亦然，这样累加
 * 1. 思路就是矩阵中的可以交换列实现全0或者全1的行他们的特征算1种，我们将特征进行归一，计算这些不同特征下的行数最大值
 * 2. 类似Code421的前缀树
 */
public class Code1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String,Integer> map=new HashMap<>();
        int res=0;
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder a=new StringBuilder();
            StringBuilder b=new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++) {
                // 以下两步操作实现了特征归一
                a.append(matrix[i][j]);
                b.append(matrix[i][j]^1);
            }
            map.put(a.toString(),map.getOrDefault(a.toString(),0)+1);
            map.put(b.toString(),map.getOrDefault(b.toString(),0)+1);
            res=Math.max(res,map.get(a.toString()));
        }
        return res;
    }
}
