package com.gopher.leetcode.types.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title Matrix
 * @Author fyw
 * @Date 2022-03-04 21:16
 * @Description
 */
public class Matrix {
    static class Code48{

    }
    static class Code1030{
        public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
            int[][] res = new int[rows*cols][2];
            int[] dx = new int[]{1, 1, -1, -1}, dy = new int[]{1, -1, -1, 1};
            res[0] = new int[]{rCenter, cCenter};
            int index = 1;
            for (int d = 1; ;d++){//枚举距离
                int x = rCenter - d, y = cCenter, cnt = 0;//cnt 这一层有多少数
                for (int i = 0; i < 4; i ++){
                    for (int j = 0; j < d; j++){
                        if (x >= 0 && x < rows && y >=0 && y < cols){
                            res[index++] = new int[]{x, y};
                            cnt++;
                        }
                        x+= dx[i];
                        y+= dy[i];
                    }
                }
                if (cnt == 0) break;
            }
            return res;
        }
    }
    static class Code764{
        public int orderOfLargestPlusSign(int N, int[][] mines) {
            boolean[][] g = new boolean[N][N];
            for (int[] m : mines) {
                g[m[0]][m[1]] = true;
            }
            int[][] f = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0, s = 0; j < N; j++) {
                    if (!g[i][j]) {
                        s++;
                    } else {
                        s = 0;
                    }
                    f[i][j] = s;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = N - 1, s = 0; j >= 0; j--) {
                    if (!g[i][j]) {
                        s++;
                    } else {
                        s = 0;
                    }
                    f[i][j] = Math.min(f[i][j], s);
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0, s = 0; j < N; j++) {
                    if (!g[j][i]) {
                        s++;
                    } else {
                        s = 0;
                    }
                    f[j][i] = Math.min(f[j][i], s);
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = N - 1, s = 0; j >= 0; j--) {
                    if (!g[j][i]) {
                        s++;
                    } else {
                        s = 0;
                    }
                    f[j][i] = Math.min(f[j][i], s);
                }
            }
            int res = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    res = Math.max(res, f[i][j]);
                }
            }
            return res;
        }
    }
    static class Code835{
        public int largestOverlap(int[][] img1, int[][] img2) {
            int res = 0;
            int n = img1.length;
            for (int i = -(n - 1); i < n; i++) {
                for (int j = -(n - 1); j < n; j++) {
                    int cnt = 0;
                    for (int x = Math.max(0, -i); x < Math.min(n, n - i); x++) {
                        for (int y = Math.max(0, -j); y < Math.min(n, n - j); y++) {
                            if (img1[i + x][j + y] == 1 && 1 == img2[x][y]) {
                                cnt++;
                            }
                        }
                    }
                    res = Math.max(res, cnt);
                }
            }
            return res;
        }
    }
    static class Code1886{

    }
    static class Code1103{
        public int[] distributeCandies(int candies, int num_people) {
            int[] res=new int[num_people];
            for (int i = 0, j=1; candies!=0; i=(i+1)%num_people,j++) {
                int cur=Math.min(candies,j);//当前应该分的糖果
                res[i]+=cur;
                candies-=cur;
            }
            return res;
        }
    }
    static class Code1072{
        // 翻转可能的每一列（列中的0 1互换），求使得互换后全0的行数与全1的行数之和
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            // 特征归类
            /**
             * 注意两个特点：
             * 1. 任何一行都可以操作变成全1或者全0
             * 2. 操作若干列就是说随便操作直到变成全0和全1为止
             *
             * 有了以上两个特点我们就知道，如果一行是与众不同的，那么在反转列使得这一列变成全0或者全1的时候，其他任何行都不会变成全0或者全1.
             * 但是如果一行与另外的一些行具有一定的特征（对应列是相反的或者相同的），那么第一行在变成全1或者全0的时候，相同特征的行也会变成全0或者全1.
             *
             * 所以我们需要寻找具有相同特征的一类里面，哪一类的行数是最多的，输出这个最多的行数
             *
             * 归类的方法就是异或
             *
             * 1. 技巧对于数字特征的处理用字符串
             * 2. 技巧对于坐标的处理用二维数组标记
             */
            int res=0;
            Map<String,Integer> map=new HashMap<>();
            for (int i = 0; i < matrix.length; i++) {
                StringBuilder a=new StringBuilder();
                StringBuilder b=new StringBuilder();
                for (int j = 0; j < matrix[0].length; j++) {
                    a.append(matrix[i][j]);
                    b.append(matrix[i][j]^1);
                }
                map.put(b.toString(),map.getOrDefault(b.toString(),0)+1);
                res=Math.max(res,map.get(b.toString()));
            }

            return res;
        }
    }
}
