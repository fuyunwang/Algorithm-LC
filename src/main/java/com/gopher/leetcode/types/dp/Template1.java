package com.gopher.leetcode.types.dp;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-01 21:36
 * @Description 子数组
 */
public class Template1 {
    static class Code53{
        // 最大子数组和
    }
    static class Code152{
        // 乘积最大的子数组
    }
    static class Code1043{
        // 分隔数组以得到最大和
        /**
         * 将该数组分隔为长度最多为k的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
         * 返回将数组分隔变换后能够得到的元素最大和
         *
         * f[i]表示前i个数的所有操作方案的最大值
         *
         * 以最后一段的长度不同分为k类
         */
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n=arr.length;
            int[] f=new int[n+1];   // 考虑前i个数所有方案的可能情况最大值

            for (int i = 1; i <= n; i++) {
                int height=0;
                int width=0;
                for (int j = i-1; j >=0 ; j--) {
                    width+=1;
                    height=Math.max(height,arr[j]);
                    if (width>k){
                        break;
                    }
                    f[i]=Math.max(f[i],f[j]+height*width);
                }
            }
            return f[n];

        }

    }

    static class Code1995{
        // 统计特殊四元组
        // 利用等式关系 nums[a] + nums[b] + nums[c] = nums[d]，具有明确的「数值」和「个数」关系，可将问题抽象为组合优化问题求方案数。
    }

}
