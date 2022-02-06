package com.gopher.leetcode.order.or1000;

import java.util.*;

/**
 * @Title Code1054
 * @Author fyw
 * @Date 2022/2/6 20:25
 * @Description:
 */
public class Code1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        // 贪心，依次从数量最多和次多的种类中取元素
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            map.put(barcodes[i],map.getOrDefault(barcodes[i],0)+1);
        }
        PriorityQueue<int[]> queue=new PriorityQueue<>((x,y)->y[1]-x[1]);
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            queue.offer(new int[]{entry.getKey(),entry.getValue()});//按照频次存储到大根堆中
        }

        List<Integer> list=new ArrayList<>();
        while (!queue.isEmpty()){
            final int[] poll1 = queue.poll();
            final int[] poll2 = queue.poll();
            list.add(poll1[0]);
            poll1[1]--;
            if (poll1[1]>0) {
                queue.offer(new int[]{poll1[0],poll1[1]});
            }
            if (poll2!=null){
                list.add(poll2[0]);
                poll2[1]--;
                if (poll2[1]>0) {
                    queue.offer(new int[]{poll2[0],poll2[1]});
                }
            }
        }

        int[] res=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}
