package com.gopher.leetcode.order.or200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title Code210
 * @Author fyw
 * @Date 2022/2/9 14:06
 * @Description: 课程表II
 * Code207课程表
 */
public class Code210 {
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
    static int[] topsort()
    {
        int[] qv = new int[n];
        int qidx = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i < n;i ++)
        {
            if(d[i] == 0)
            {
                qv[qidx ++] = i;
                q.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int t = q.poll();
            for(int i = h[t]; i != -1;i = ne[i])
            {
                int j = e[i];
                //删除当前边
                d[j] --;
                if(d[j] == 0)
                {
                    qv[qidx ++] = j;
                    q.add(j);
                }
            }
        }
        if(qidx < n) return new int[]{};
        return qv;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        n = numCourses;
        m = prerequisites.length;
        Arrays.fill(h, -1);
        Arrays.fill(e, 0);
        Arrays.fill(ne, 0);
        Arrays.fill(d, 0);
        for(int i = 0;i < m;i ++)
        {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            add(b, a);
            d[a] ++;
        }

        return topsort();
    }
}
