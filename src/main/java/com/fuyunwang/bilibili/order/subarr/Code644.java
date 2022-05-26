package com.fuyunwang.bilibili.order.subarr;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code644
 * @Author fyw
 * @Date 2022-05-25 9:07
 * @Description 子数组最大平均数II
 */
public class Code644 {
//    public double findMaxAverage(int[] nums, int k) {
//        int n=nums.length;
//        int[] sum=new int[n+10];
//        for (int i = 1;i<=n;i++) {
//            sum[i]=sum[i-1]+nums[i-1];
//        }
//        double res=Double.MIN_VALUE;
//        // 求最大的平均值，需要固定每一个元素作为结尾找之前的最小值
//        Deque<Integer> deque=new ArrayDeque<>();
//        deque.addLast(0);
//        for (int i = 1; i <=n ; i++) {
//            // 计算平均值
//            if (!deque.isEmpty()){
//                double cur=(sum[i]-sum[deque.peekFirst()])*1.0/(i-deque.peekFirst());
//            }
//            res=Math.max(res,(sum[i]-sum[deque.peekFirst()])*1.0/(i-deque.peekFirst()));
//        }
//    }
}
