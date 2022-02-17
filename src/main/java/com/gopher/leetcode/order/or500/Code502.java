package com.gopher.leetcode.order.or500;

import java.util.*;

/**
 * @Title Code502
 * @Author fyw
 * @Date 2022/2/9 14:12
 * @Description: IPO
 * 贪心
 * 本质上是按照capital从小到大排序，取出满足小于等于w的所有元素加入按照profits排序的大根堆，取前K次得到最大利润。
 * 注意一次就改变当前拥有资金，所以采用循环加入所有满足条件的项目用于构造大根堆
 */
public class Code502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //注意profits和Capital进行捆绑
        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < capital.length; i++) {
            list.add(new int[]{capital[i],profits[i]});
        }
        Collections.sort(list,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->b[1]-a[1]);   // 按利润的大根堆
        int i=0;
        while (k-->0){
            while (i<list.size()&&list.get(i)[0]<=w){
                queue.offer(list.get(i++));
            }
            if (queue.isEmpty()){
                break;
            }
            w+=queue.poll()[1];
        }
        return w;
    }
}
