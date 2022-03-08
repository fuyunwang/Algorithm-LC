package com.gopher.leetcode.types.graph;

import com.gopher.hardcoding.graph.BFS;

import java.io.IOException;
import java.util.LinkedList;

/**
 * @Title Template2
 * @Author fyw
 * @Date 2022-03-08 10:47
 * @Description Floyd
 */
public class Template2 {
    static class AcwingCode1100{
        // 抓住那头牛
        static int n,m;// 分别表示人的位置和牛的位置
        public static void main(String[] args) throws IOException {
            bfs(n, m);
        }

        private static void bfs(int n, int m) {
            int[] step = new int[Math.max(n + 1, m * 2)];
            LinkedList<Point> q = new LinkedList<>();
            q.add(new Point(n, 1));

            while (!q.isEmpty()) {
                Point p = q.poll();
                if (step[p.val] == 0) {
                    step[p.val] = p.step;

                    if (p.val == m) {
                        System.out.println(p.step-1);       /// 最优步数
                        return;
                    }
                    if (p.val < m)
                        q.add(new Point(p.val * 2, p.step + 1));

                    if (p.val < m)
                        q.add(new Point(p.val + 1, p.step + 1));

                    if (p.val > 0)
                        q.add(new Point(p.val - 1, p.step + 1));
                }
            }

        }
        static class Point {
            int val;
            int step;
            public Point(int val, int step) {
                this.val = val;
                this.step = step;
            }
        }
    }
    static class Code754{
        public int reachNumber(int target) {
            int t = Math.abs(target);
            int s = 0;
            int dis = 0;
            while (dis < t) {
                s++;
                dis += s;

            }
            int dt = dis - t;
            if (dt % 2 == 0)
                return s;
            else {
                if (s % 2 == 0)
                    return s + 1;
                else
                    return s + 2;
            }
        }
    }

}
