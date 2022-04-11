package com.gopher.leetcode.order.or1100;

import java.util.Arrays;

/**
 * @Title Code1105
 * @Author fyw
 * @Date 2022-03-05 20:46
 * @Description 填充书架
 * Acwing 绿色通道，单调队列优化
 */
public class Code1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n=books.length;
        int[] f=new int[n+1]; // 考虑前i本书摆放方案的高度最小值
        Arrays.fill(f,Integer.MAX_VALUE);
        f[0]=0;
        for (int i = 1; i <= n; i++) {  // 递推计算要枚举每一本书作为最后一本书的情况
            int height=0;
            int width=0;
            for (int j = i-1; j >= 0; j--) {    // 最后一层摆放第i本（索引是i-1）、第i和i-1本、。。。。
                width+=books[j][0];
                height=Math.max(height,books[j][1]);
                if (width>shelfWidth)
                    break;
                f[i]=Math.min(f[i],f[j]+height);    // 注意这里的索引又是另外一码事
            }
        }
        return f[n];
    }
}
