package com.gopher.leetcode.order.or700;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Title Code752
 * @Author fyw
 * @Date 2022/2/14 12:14
 * @Description: 打开转盘锁
 * Code994，状态宽搜
 */
public class Code752 {
    HashSet<String> set=new HashSet<>();
    HashSet<String> path=new HashSet<>(); // 避免循环回路
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000"))
            return 0;
        if (set.contains(target)||set.contains("0000"))
            return -1;
        for (String dead:deadends){
            set.add(dead);
        }
        Queue<String> queue=new LinkedList<>();
        queue.offer("0000");
        int res=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                final String poll = queue.poll();
                if (path.contains(poll)){
                    continue;
                }
                path.add(poll);
                if (set.contains(poll)){
                    return -1;
                }
                if (poll.equals(target)){
                    return res;
                }
                final char[] pollChars = poll.toCharArray();
                for (int j = 0; j < 4; j++) {   // 遍历图中的四个方向
                    char o=pollChars[j];
                    pollChars[j]=Character.forDigit((pollChars[j]-'0'+1)%10,10);
                    final String s1 = String.valueOf(pollChars);
                    if (!set.contains(s1)){
                        queue.offer(s1);
                    }
                    pollChars[j]=o;
                    pollChars[j]=Character.forDigit((pollChars[j]-'0'+9)%10,10);
                    final String s2=String.valueOf(pollChars);
                    if (!set.contains(s2)){
                        queue.offer(s2);
                    }
                    pollChars[j]=o;
                }
            }
            res++;
        }
        return -1;
    }
}
