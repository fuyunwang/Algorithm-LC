package com.gopher.leetcode.types.graph;

import com.gopher.hardcoding.graph.BFS;

import java.io.IOException;
import java.util.*;

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

    static class Code780{
         public boolean reachingPoints(int sx, int sy, int tx, int ty) {
             while (tx >= sx && ty >= sy) {
                 if (tx == ty) break;
                 if (tx > ty) {
                     if (ty > sy) tx %= ty;
                     else return (tx - sx) % ty == 0;
                 } else {
                     if (tx > sx) ty %= tx;
                     else return (ty - sy) % tx == 0;
                 }
             }
             return (tx == sx && ty == sy);
         }
    }

    static class Code1005{
        public int largestSumAfterKNegations(int[] nums, int k) {
            int n = nums.length;
            // 记录最小的一个负数,在k的范围内 从小到大记录负数, 把对应的负数转成正数
            // 如果负数cnt的个数<k, 再根据k-cnt的奇偶性, 如果是奇数, 结果减去2*|最小绝对值数|, 如果是偶数, 则不需要更改正数


            Arrays.sort(nums);
            int sum = 0, cnt = 0, minv = 0x3f3f3f3f;
            // 记录最小的绝对值数
            for (int i = 0; i < nums.length; i ++){
                sum += nums[i];
                minv = Math.min(minv, Math.abs(nums[i]));
            }
            // System.out.println(minv);
            // 负数->正数
            for (int i = 0; i < nums.length && nums[i] < 0 && k > 0;i ++){
                sum += 2 * Math.abs(nums[i]);
                k --;
            }
            // System.out.println(sum);
            if (k % 2 == 1) sum -= 2 * minv;
            return sum;
        }
    }

    static class Code991{
        public int brokenCalc(int x, int y) {
            int res =  0;
            while(y>x){
                if(y%2>0)y++;
                else y/=2;
                res++;

            }
            return res+x-y;
        }
    }
}
