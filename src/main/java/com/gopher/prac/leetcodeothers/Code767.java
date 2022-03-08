package com.gopher.prac.leetcodeothers;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Title Code767
 * @Author fyw
 * @Date 2022-03-08 21:18
 * @Description
 */
public class Code767 {
    public String reorganizeString(String s) {
        Map<Character,Integer> map=new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c: chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Pair> queue=new PriorityQueue<>((a,b)->b.count-a.count);
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            if (entry.getValue()>((s.length()+1)/2))
                return "";
            queue.offer(new Pair(entry.getKey(),entry.getValue()));
        }
        StringBuilder sb=new StringBuilder();
        while (!queue.isEmpty()){
            Pair poll = queue.poll();
            sb.append(poll.c);
            Pair second = null;
            if (!queue.isEmpty()){
                second=queue.poll();
                sb.append(second.c);
            }
            if (--poll.count>0){
                queue.offer(poll);
            }
            if (second!=null&&--second.count>0){
                queue.offer(second);
            }
        }
        return sb.toString();
    }
    class Pair{
        char c;
        int count;

        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
