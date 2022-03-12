package com.gopher.ending.structure.unionset;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022/3/12 20:27
 * @Description:
 */
public class Template1 {
    static class Code765{
        int[] p;

        public int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        public int minSwapsCouples(int[] row) {
            int n = row.length / 2;
            p = new int[n];
            for (int i = 1; i < n; i++) {
                p[i] = i;
            }
            int cnt = n;
            for (int i = 0; i < row.length; i += 2) {
                int a = row[i];
                int b = row[i + 1];
                int pa = find(a / 2);
                int pb = find(b / 2);
                if (pa != pb) {
                    p[pa] = pb;
                    cnt--;
                }
            }
            return n - cnt;
        }
    }
    static class Code721{
        // 账户合并
    }
}
