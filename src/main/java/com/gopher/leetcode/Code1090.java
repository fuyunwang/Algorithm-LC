package com.gopher.leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Title Code1090
 * @Author fyw
 * @Date 2022/2/6 14:26
 * @Description:
 * 从所有物品中拿出numWanted个，其中每一种物品（物品的种类即使标签代表的）的数量都不超过useLimit个，问怎么拿价值最大。从最大值贪心取
 */
public class Code1090 {

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        PriorityQueue<Information> queue=new PriorityQueue<>((x,y)->y.value-x.value);
        for (int i = 0; i < values.length; i++) {
            queue.offer(new Information(values[i],labels[i]));
        }
        int res=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while (!queue.isEmpty()&&numWanted>0){
            final Information poll = queue.poll();
            map.put(poll.label,map.getOrDefault(poll.label,0)+1);
            if (map.get(poll.label)>useLimit)   // 此种类物品已经不能选了
                continue;
            res+=poll.value;
            numWanted--;
        }
        return res;
    }

    class Information{
        int value;
        int label;

        public Information(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }
}
