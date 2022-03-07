package com.gopher.leetcode.order.or1000;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Title Code1036
 * @Author fyw
 * @Date 2022-03-07 10:16
 * @Description 逃离大迷宫
 */
public class Code1036 {
    /**
     * 尽可能让障碍物围成一个大的区域，保证其中一个点在区域内部
     * 200个障碍物只能围成2W个格子
     */
    Set<String> set = new HashSet<>();      // 标记是否是障碍物
    int n = (int) 1e6;
    int m = (int) 1e6;
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    public boolean bfs(int[] source, int[] target) {
        Set<String> cur = new HashSet<>();  // 标记枚举的位置是否是障碍物或者已经被访问过
        for (String s : set) {
            cur.add(s);
        }
        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(source);
        cur.add(source[0] + " " + source[1]);
        while (q.size() > 0) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !cur.contains(nx + " " + ny)) {
                    cnt++;
                    if (nx == target[0] && ny == target[1]) {
                        return true;
                    }
                    if (cnt > (m - 1) * m / 2) {
                        return true;
                    }
                    q.add(new int[]{nx, ny});
                    cur.add(nx + " " + ny);
                }
            }
        }
        return false;
    }

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        for (int[] b : blocked) {
            set.add(b[0] + " " + b[1]);
        }
        m = blocked.length;
        return bfs(source, target) && bfs(target, source);
    }

}