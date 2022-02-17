package com.gopher.leetcode.order.or800;

import java.util.Arrays;

/**
 * @Title Code825
 * @Author fyw
 * @Date 2022/2/9 13:57
 * @Description:
 */
public class Code825 {
    public int numFriendRequests(int[] ages) {
        int n=ages.length;
        int res=n*n;    // 最多包括环会存在这些边
        int[] s=new int[121];
        Arrays.fill(s,0);
        for (int i = 0; i < ages.length; i++) {
            s[ages[i]]++;   // 直方图统计每一个年龄段的人的数量
        }
        // 遍历每一个年龄段的每一种情况
        for (int i = 1; i <= 120; i++) {
            for (int j = 1; j <= 120; j++) {
                if (j<=0.5*i+7||j>i){
                    res-=s[j]*s[i];
                }else if(j==i){
                    res-=s[i];
                }
            }
        }
        return res;
    }
}
