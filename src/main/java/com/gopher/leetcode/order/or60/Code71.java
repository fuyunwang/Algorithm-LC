package com.gopher.leetcode.order.or60;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Title Code71
 * @Author fyw
 * @Date 2022/2/9 12:27
 * @Description: 简化路径，双端队列来解决
 */
public class Code71 {
    public String simplifyPath(String path) {
        Deque<String> deque=new ArrayDeque<>();
        String[] names=path.split("/");
        for (int i = 0; i < names.length; i++) {
            if ("..".equals(names[i])){
                deque.pollLast();
            }else if (names[i].length()>0&&!".".equals(names[i])){
                deque.offerLast(names[i]);
            }
        }
        StringBuilder sb=new StringBuilder();
        if (deque.isEmpty()){
            sb.append("/");
        }else{
            while (!deque.isEmpty()){
                sb.append("/");
                sb.append(deque.pollFirst());
            }
        }
        return sb.toString();
    }
}
