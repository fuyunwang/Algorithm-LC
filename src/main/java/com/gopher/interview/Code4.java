package com.gopher.interview;

/**
 * @Title Code4
 * @Author fyw
 * @Date 2022/1/30 15:12
 * @Description: 寻找矩阵极小值，Code162
 */
public class Code4 {
    interface Getvalue{
        int query(int x, int y);
    }
    class Solution implements Getvalue{
        public int[] getMinimumValue(int n) {
            int  lo = 0, hi = n-1;

            while (lo < hi) {
                int mid = lo + (hi - lo >> 1); // 注意这里，不要写成 lo + (hi - lo) >> 1，>>的优先级低

                // 找到中间一列的最小值
                int min = Integer.MAX_VALUE;
                int minIndex = -1; // 行的索引
                for (int i = 0; i < n; i++) {
                    int temp = query(i, mid);
                    if (min > temp) {
                        min = temp;
                        minIndex = i;
                    }
                }

                // mid+1 一定存在，因为 mid 最大为 n-2, 但 mid-1 不一定存在，因为 mid 最小可以为0
                if (mid <= 0) {
                    lo = mid + 1;
                } else if (query(minIndex, mid-1) > min && query(minIndex, mid+1) > min) {
                    return new int[]{minIndex, mid};
                }

                if (query(minIndex, mid-1) < min) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            // 找到最后一列（lo == hi）的最小值
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < n; i++) {
                int temp = query(i, lo); // 这里用 lo 和 hi 一样
                if (min > temp) {
                    min = temp;
                    minIndex = i;
                }
            }

            return new int[]{minIndex, lo};
        }

        @Override
        public int query(int x, int y) {
            return 0;
        }
    }
}
