package com.gopher.leetcode.types.dp;

/**
 * @Title Code1043
 * @Author fyw
 * @Date 2022/2/6 15:08
 * @Description:
 * 经典线性DP与Code1105完全一样
 */
public class Code1043 {
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
