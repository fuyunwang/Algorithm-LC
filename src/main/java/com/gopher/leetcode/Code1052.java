package com.gopher.leetcode;

/**
 * @Title Code1052
 * @Author fyw
 * @Date 2022/2/6 19:41
 * @Description: 爱生气的书店老板
 * 前缀和
 */
public class Code1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int len=customers.length;
        int sum=0;
        for (int i = 0; i < len; i++) {
            //首先计算再不采取不生气策略时的满意人数
            if (grumpy[i]==0){
                sum+=customers[i];
                // 注意本题使用前缀和解决，这里采用擦除策略防止重复加
                customers[i]=0;
            }
        }
        // 使用前缀和策略来选择最佳方式
        int presum=0;
        int max=0;
        for (int i = 0; i < len; i++) {
            if (i<minutes)
                presum+=customers[i];
            else
                presum=presum+customers[i]-customers[i-minutes];
            // 记录哪一种方式下的前缀和策略最优
            max=Math.max(max,presum);
        }
        return sum+max;
    }
}
