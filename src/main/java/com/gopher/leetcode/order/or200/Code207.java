package com.gopher.leetcode.order.or200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title Code207
 * @Author fyw
 * @Date 2022/2/8 22:04
 * @Description: 课程表
 * 经典有向图求拓扑排序
 */
public class Code207 {
    static int N = 100010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] d = new int[N];
    static int idx = 0;
    static int n ;
    static int m ;
    static void add(int a,int b)
    {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
    static boolean topsort()
    {
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i < n;i ++)
        {
            if(d[i] == 0)
                q.add(i);
        }
        int cnt = 0;
        while(!q.isEmpty())
        {
            int t = q.poll();
            cnt ++;
            for(int i = h[t]; i != -1;i = ne[i])
            {
                int j = e[i];
                //删除当前边
                d[j] --;
                if(d[j] == 0) q.add(j);
            }
        }
        return cnt == n;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        n = numCourses;
        m = prerequisites.length;
        if(m == 0) return true;
        Arrays.fill(h, -1);
        Arrays.fill(e, 0);
        Arrays.fill(ne, 0);
        Arrays.fill(d, 0);
        for(int i = 0;i < m;i ++)
        {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            add(b, a);      // ；邻接表
            d[a] ++;
        }

        return topsort();
    }

}
