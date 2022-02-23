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
public class Code118_119 {
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
    // Code119 滚动数组，&1相当于%2并且优先级小于加减运算
    public List<Integer> getRow(int rowIndex) {
        int[][] f=new int[2][rowIndex+1];
        for (int i = 0; i <= rowIndex; i++) {
            f[i&1][0]=f[i&1][i]=1;
            for (int j = 1; j <i ; j++) {
                f[i&1][j]=f[i-1&1][j-1]+f[i-1&1][j];
            }
        }
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < f[rowIndex&1].length; i++) {
            res.add(f[rowIndex&1][i]);
        }
        return res;
    }
}
