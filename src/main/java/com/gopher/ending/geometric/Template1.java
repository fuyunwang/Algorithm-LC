package com.gopher.ending.geometric;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022/3/12 17:48
 * @Description: 几何图形
 */
public class Template1 {
    static class Code221{
        // 最大正方形 DP
        public int maximalSquare(char[][] matrix) {
            if(matrix.length == 0 || matrix[0].length == 0) return 0;
            int n = matrix.length, m = matrix[0].length;
            int[][] f = new int[n + 1][m + 1];
            int res = 0;
            for(int i = 1;i <= n;i ++)
                for(int j = 1;j <= m;j ++)
                    if(matrix[i - 1][j - 1] == '1')
                    {
                        f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                        res = Math.max(res, f[i][j]);
                    }

            return res * res;
        }
    }

    static class Code850{
        // 矩形面积II
    }

    static class Code812{
        // 最大三角形面积
    }
}
