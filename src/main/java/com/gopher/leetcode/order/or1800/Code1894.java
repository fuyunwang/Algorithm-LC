package com.gopher.leetcode.order.or1800;

/**
 * @Title Code1894
 * @Author fyw
 * @Date 2022/2/9 14:44
 * @Description:
 * 前缀和+二分
 */
public class Code1894 {
    public int chalkReplacer(int[] chalk, int k) {
        long[] sum=new long[chalk.length+1];
        for (int i = 1; i <= chalk.length; i++) {
            sum[i]=sum[i-1]+chalk[i-1];
        }
        k=(int) (k%sum[chalk.length]);
        int l=1,r=chalk.length;
        while (l<r){
            int mid=l+r+1>>1;
            if (sum[mid]<=k){   // 说明此时k个粉笔还有富余，消耗量还用不完
                l=mid;
            }else{
                r=mid-1;
            }
        }
        return sum[r]<=k?r:r-1;
    }
}
