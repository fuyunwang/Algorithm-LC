package com.gopher.leetcode.order.or1000;

/**
 * @Title Code1092
 * @Author fyw
 * @Date 2022-03-05 16:41
 * @Description 最短公共超序列
 * 相当于扩充str1然后使其包含str2
 */
public class Code1092 {
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
