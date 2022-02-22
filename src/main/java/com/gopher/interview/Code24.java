package com.gopher.interview;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Title Code24
 * @Author fyw
 * @Date 2022-02-22 10:54
 * @Description 超市
 * 贪心。在有限的过期时间内获得最大的收益.
 * 首先对原数组进行二维规则排序，如果过期时间相等则按照利润从大到小排序否则按照过期时间从小到大排序
 * 其次构造按照利润从小到大排序的小根堆
 */
public class Code24 {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int counts = scanner.nextInt();
            int[][] goods = new int[counts][2];
            for (int i = 0; i < counts; i++) {
                goods[i][0] = scanner.nextInt();    // 利润
                goods[i][1] = scanner.nextInt();    // 过期时间
            }
            Arrays.sort(goods, (o1, o2) -> o1[1] != o2[1]?o1[1] - o2[1] : o2[0] - o1[0]);

            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

            for (int i = 0; i < counts; i++) {
                priorityQueue.add(goods[i]);
                if (priorityQueue.size() > goods[i][1]){
                    priorityQueue.poll();
                }
            }
            int res = 0;
            while (priorityQueue.size() > 0){
                res += priorityQueue.poll()[0];
            }
            System.out.println(res);
        }

    }
    public static void main(String[] args) {
        new Code24().run();
    }
}
