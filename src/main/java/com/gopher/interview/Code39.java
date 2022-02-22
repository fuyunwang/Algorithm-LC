package com.gopher.interview;

import java.util.*;

/**
 * @Title Code39
 * @Author fyw
 * @Date 2022-02-22 11:02
 * @Description 八数码
 * BFS
 */
public class Code39 {
    static Map<String, Integer> map = new HashMap<>(); // 记录最小步数

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);

        String str = "";

        for (int i = 0; i < 9; i ++){
            str += cin.next();
        }

        System.out.print(bfs(str));
    }

    static int bfs(String str){

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<String> q = new LinkedList<>();
        q.add(str);
        map.put(str, 0);
        while (!q.isEmpty()){
            String t = q.remove();
            if (t.equals("12345678x")) return map.get(t);
            int pos = t.indexOf('x');
            // 注意一位数组对应二位数组索引的变换
            int x = pos / 3;
            int y = pos % 3;
            for (int i = 0; i < 4; i ++){
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (tx < 0 || tx >= 3 || ty < 0 || ty >= 3) continue;
                String tstr = makeStr(t, pos, tx * 3 + ty);
                if (map.containsKey(tstr)) continue;
                map.put(tstr, map.get(t) + 1);
                q.add(tstr);
            }
        }
        return -1;
    }

    static String makeStr(String t, int originPos, int targetPos){
        StringBuilder str = new StringBuilder(t);
        str.setCharAt(originPos, t.charAt(targetPos));
        str.setCharAt(targetPos, 'x');
        return str.toString();
    }
}
