package com.gopher.ending.graph;

import java.util.*;

/**
 * @Title BermanFloyd
 * @Author fyw
 * @Date 2022/3/12 23:50
 * @Description:
 */
public class BermanFloyd {
    static class Code787{
        // 循环K次代表，经过不超过K条边最短路的距离，所以将k+1
        // 松弛操作的含义：从起点到v的距离更近，还是上一步从u到v的距离更近
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            int dist[] = new int[n];
            Arrays.fill(dist,0x3f3f3f);
            dist[src] = 0;

            for(int i=0;i<=K;i++){
                int temp[] = new int[n];
                temp = Arrays.copyOf(dist,n);
                for(int f[] : flights){
                    int u = f[0],v = f[1], w = f[2];
                    temp[v] = Math.min(temp[v],dist[u]+w);
                }
                dist = temp;
            }

            return dist[dst] == 0x3f3f3f? -1 : dist[dst];
        }
    }
}
