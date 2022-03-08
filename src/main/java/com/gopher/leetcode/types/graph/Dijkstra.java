package com.gopher.leetcode.types.graph;

import java.util.*;

/**
 * @Title Dijstra
 * @Author fyw
 * @Date 2022-03-03 22:25
 * @Description
 */
public class Dijkstra {
    static class Code1514{
    }
    static class Code743{
        // 单源最短路径
        public int networkDelayTime(int[][] times, int n, int k) {
            int[][] g = new int[n + 1][n + 1];
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    g[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int[] t : times) {
                g[t[0]][t[1]] = t[2];
            }
            int[] dist = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                g[i][i] = 0;
                dist[i] = Integer.MAX_VALUE;
            }
            dist[k] = 0;

            PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });

            minHeap.offer(new int[]{0, k});
            while (!minHeap.isEmpty()) {
                int[] cur = minHeap.poll();
                int time = cur[0], x = cur[1];
                if (time > dist[x]) continue;
                for (int y = 1; y <= n; ++y) {
                    if (g[x][y] != Integer.MAX_VALUE && time + g[x][y] < dist[y]) {
                        System.out.println(y);
                        dist[y] = time + g[x][y];
                        minHeap.offer(new int[]{dist[y], y});
                    }
                }
            }

            int res = -1;
            for (int i = 1; i <= n; ++i) {
                if (dist[i] == Integer.MAX_VALUE) return -1;
                res = Math.max(res, dist[i]);
            }
            return res;
        }

    }
}
