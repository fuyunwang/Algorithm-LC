package com.gopher.leetcode.types.greed;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-06 20:38
 * @Description 
 */
public class Template1 {
    static class Code1090{
        /**
         *  有一些物品，每个物品都有一个价值value以及该物品的对应编号label。
         *  我们需要从中拿出来num_wanted个物品，希望物品价值最大，并且每一类物品不超过use_limit个，求最大价值
         *  标签代表种类，种类下面有不同价值的商品，我们先混起来，按照价值排序，然后看是否超出了拿的预期
         */
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            PriorityQueue<Information> queue=new PriorityQueue<>((p1, p2)-> p2.value-p1.value); // 贪心拿，从价值最大的物品开始取
            for (int i = 0; i < values.length; i++) {
                queue.offer(new Information(labels[i],values[i]));
            }
            // 记录一下每一种类已经拿了多少个
            Map<Integer,Integer> map=new HashMap<>();

            int res=0;
            while (!queue.isEmpty()&&numWanted>0){
                Information poll = queue.poll();
                map.put(poll.label,map.getOrDefault(poll.label,0)+1);
                if (map.get(poll.label)>useLimit){
                    continue;// 这一种类的就弹出一个
                }
                res+=poll.value;
                --numWanted;
            }

            return res;
        }

        class Information{
            int label;
            int value;
            public Information(int label, int value) {
                this.label = label;
                this.value = value;
            }
            @Override
            public boolean equals(Object o) {
                if (o==null)
                    return false;
                if (o==this)
                    return true;
                if (o instanceof Information){
                    Information cur= (Information) o;
                    return cur.label==this.label&&cur.value==this.value;
                }
                return false;
            }
            @Override
            public int hashCode() {
                int res=17;
                res=res*31+this.label;
                res=res*31+this.value;
                return res;
            }
        }
    }
}
