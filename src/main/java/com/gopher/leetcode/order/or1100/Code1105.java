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
