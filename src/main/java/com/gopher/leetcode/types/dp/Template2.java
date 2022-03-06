package com.gopher.leetcode.types.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title Template2
 * @Author fyw
 * @Date 2022-03-03 16:45
 * @Description
 */
public class Template2 {
    // 顺序不同的序列被视作不同的组合。
    static class Code377{
        // 状态表示：定义f[i][j]为组合长度为i，凑成总和为j的方案数是多少。由于对组合方案的长度没有限制，因此我们最终答案为所有的f[x][target]的总和。
        // 状态计算：那么对任意的f[len][target]而言，组合中的最后一个数字可以选择nums中的任意数值。 f[len][target]=f[len-1][target-nums[0]]+f[len-1][target-nums[1]]+...
        public int combinationSum4(int[] nums, int target) {
            // 因为 nums[i] 最小值为 1，因此构成答案的最大长度为 target
            int len=target;
            int[][] f=new int[len+10][target+10];
            f[0][0]=1;
            int res=0;
            for (int i = 1; i <= len; i++) {
                for (int j = 0; j <= target; j++) {
                    for (int k = 0; k < nums.length; k++) {
                        // 做选择，target的值需要存储下nums[k]才可，完全背包
                        if (j>=nums[k]){
                            f[i][j]=f[i][j]+f[i-1][j-nums[k]];
                        }
                    }
                }
                res+=f[i][target];
            }
            return res;
        }
    }
    static class Code1014{

    }
    static class Code1092{
        public String shortestCommonSupersequence(String str1, String str2) {
            /**
             * f[i][j]表示字符串1的前i位进行扩充直到包含字符串2的前j位的最小方案数
             *
             * 集合划分依据就是当前最后一个字符是否相等
             */
            int n=str1.length();
            int m=str2.length();
            // 我这里没有将str1和str2前面加“ ”补齐，所以后续索引对应应该注意
            int[][] f=new int[n+1][m+1];
            for (int i = 0; i <= n; i++) {
                f[i][0]=0;
            }
            for (int i = 1; i <= m; i++) {
                f[0][i]=i;
            }

            // dp 的核心思想就是前面的都已经匹配好了，只需要考虑当前这位。
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (str1.charAt(i-1)==str2.charAt(j-1)){    // 如果当前字符相等那么说明不需要扩充，结果仍然是去掉当前这位的结果
                        f[i][j]=f[i-1][j-1];
                    }else{
                        // 考虑既要包含a又要包含b的情况。可以保证a已经包含b是f[i-1][j]，可以保证a还差一个字符才包含b的情况f[i][j-1]+1。以上两种情况都一定保证是满足要求所以取最小的可能方案
                        f[i][j]=Math.min(f[i][j-1]+1,f[i-1][j]);
                    }
                }
            }

            StringBuilder sb=new StringBuilder();
            for (int i = n,j=m; i>0||j>0;) {
                if (i==0){
                    sb.append(str2.charAt(--j));
                }else if (j==0){
                    sb.append(str1.charAt(--i));
                }else{
                    if (str1.charAt(i-1)==str2.charAt(j-1)){
                        sb.append(str1.charAt(--i));
                        --j;
                    }else{
                        if (f[i][j]==f[i][j-1]+1){
                            sb.append(str2.charAt(--j));
                        }else{
                            sb.append(str1.charAt(--i));
                        }
                    }
                }
            }
            return sb.reverse().toString();
        }
    }
}
