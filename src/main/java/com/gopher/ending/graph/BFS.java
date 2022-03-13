package com.gopher.ending.graph;

import java.util.*;

/**
 * @Title BFS
 * @Author fyw
 * @Date 2022/3/13 10:42
 * @Description:
 */
public class BFS {
    static class Code864{
        // 类似双端队列求 AcWing1131
    }
    static class Code815{
        // 公交路线，一类题型，多个环相交求经过几个环
        // 多源多汇
        public int numBusesToDestination(int[][] routes, int source, int target) {
            if (source == target) return 0;
            int n = routes.length;
            Map<Integer, List<Integer>> map = new HashMap();// 每个站点会挂载哪些环线
            int[] dist = new int[n];
            Arrays.fill(dist, 1000000);
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++){//遍历所有路线
                for (int x:routes[i]){
                    if (x == source){
                        dist[i] = 1;
                        queue.add(i);
                    }
                    if (map.get(x) == null){
                        map.put(x, new ArrayList<>());
                    }
                    map.get(x).add(i);
                }
            }
            while (!queue.isEmpty()){
                int t = queue.poll();
                for (int x:routes[t]){
                    if (x == target) return dist[t];
                    if (map.get(x) != null){
                        for (int y:map.get(x)){
                            if (dist[y] > dist[t] + 1){
                                dist[y] = dist[t] + 1;
                                queue.add(y);
                            }
                        }
                        map.remove(x);
                    }
                }
            }
            return -1;
        }
    }
}
