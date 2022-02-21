package com.gopher.coding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title TopologicalTraverse
 * @Author fyw
 * @Date 2022-02-21 14:09
 * @Description
 * 有向无环图就是拓扑图
 */
public class TopologicalTraverse {
    static class LeetCode207{
        // 拓扑排序判断是否有环
        static int N = 100010;
        static int[] h = new int[N];    // n个链表的链表头，初始都是-1表示指向空节点
        static int[] e = new int[N];    //
        static int[] ne = new int[N];   //
        static int[] d = new int[N];
        static int idx = 0;
        static int n ;
        static int m ;

        static boolean topsort() {
            Queue<Integer> q = new LinkedList<Integer>();
            for(int i = 0;i < n;i ++) {
                if(d[i] == 0)   // 入度为0的点加入队列
                    q.add(i);
            }
            int cnt = 0;
            while(!q.isEmpty()) {
                int t = q.poll();
                cnt ++;
                for(int i = h[t]; i != -1;i = ne[i]) {
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
                add(b, a);      // 邻接表
                d[a] ++;        // a的入度增加 b->a
            }
            // 进行拓扑排序
            return topsort();
        }
        // 邻接表构图，数组模拟链表进行头插法 h数组保存当前节点的头
        static void add(int a,int b) { // a和b都是点
            // 整体的流程是：对于每条边，e记录每一条编号边的下一个点 （-->b）; ne记录每一条编号边的上一个点（-->b，注意这里是邻接表意义中的下一个点）;
            // h记录每一个节点的邻接表头，其值为下一跳编号边，这就与e对应起来了
            e[idx] = b;     // idx的含义是当前节点的编号，e为当前节点的边表
            ne[idx] = h[a]; // 头插法，每次将当前头结点作为新加入节点的尾节点。ne[idx]表示idx节点的尾节点，注意这里记录的都是索引而不是值
            h[a] = idx ++;  // 原来头结点的链表进行更新
        }
    }
}
