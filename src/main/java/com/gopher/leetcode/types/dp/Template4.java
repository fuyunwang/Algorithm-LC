package com.gopher.leetcode.types.dp;

import java.util.Arrays;

/**
 * @Title Template4
 * @Author fyw
 * @Date 2022-03-05 20:26
 * @Description
 */
public class Template4 {
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
    static class Code1105{
        // 题意是要求把所有书摆放到所有书架上，要求每一层书架的厚度能容纳当前层数的总厚度同时书架的总高度最小
        public int minHeightShelves(int[][] books, int shelfWidth) {
            /**
             * f[i]表示考虑前i本书时高度的最小值
             */
            int[] f=new int[books.length+1];
            Arrays.fill(f,Integer.MAX_VALUE);
            f[0]=0;
            for (int i = 1; i <= books.length; i++) {
                int curWidth=0;
                int curHeight=0;
                for (int j = i-1; j >=0; j--) {   // 对前i-1本书的摆放情况进行考虑。当仅第i本书放最后一层时的高度、第i-1和第i本书都放最后一层的高度、...、第1到第i本书都放最后一层的高度
                    curWidth+=books[j][0];
                    curHeight=Math.max(books[j][1],curHeight);
                    if (curWidth>shelfWidth)
                        break;
                    f[i]=Math.min(f[i],f[j]+curHeight);
                }
            }

            return f[books.length];

        }
    }
}
