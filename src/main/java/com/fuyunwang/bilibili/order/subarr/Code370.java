package com.fuyunwang.bilibili.order.subarr;

/**
 * @Title Code370
 * @Author fyw
 * @Date 2022-05-25 16:46
 * @Description 区间加法
 */
public class Code370 {
    /**
     * 经典差分数组应用
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res=new int[length];
        for (int i = 0; i < updates.length; i++) {
            res[updates[i][0]]+=updates[i][2];
            if (updates[i][1]+1<res.length){
                res[updates[i][1]+1]-=updates[i][2];
            }
        }
        for (int i = 1; i < res.length; i++) {
            res[i]+=res[i-1];
        }
        return res;
    }
}
