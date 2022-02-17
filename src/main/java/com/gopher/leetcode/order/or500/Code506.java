package com.gopher.leetcode.order.or500;

import java.util.Arrays;

/**
 * @Title Code506
 * @Author fyw
 * @Date 2022/2/9 14:07
 * @Description: 相对名次
 * 计数排序，使用值与索引捆绑的策略
 */
public class Code506 {
    public String[] findRelativeRanks(int[] score) {
        // 计数策略，首先确定数据范围
        int max=0;
        for (int i = 0; i < score.length; i++) {
            max=Math.max(max,score[i]);
        }
        // 声明数组，初始赋值为不会取到的数据
        int[] count=new int[max+1];
        Arrays.fill(count,-1);
        // 进行索引和数据的捆绑
        for (int i = 0; i < score.length; i++) {
            count[score[i]]=i;
        }
        // 进行数据的整理，从大到小排列
        String[] res=new String[score.length];
        int rank=1;
        while (max>=0){
            if(count[max]>=0){
                if (rank==1){
                    res[count[max]]="Gold Medal";
                }else if (rank==2){
                    res[count[max]]="Silver Medal";
                }else if (rank==3){
                    res[count[max]]="Bronze Medal";
                }else{
                    res[count[max]]=String.valueOf(rank);
                }
                rank+=1;
            }

            max-=1;
        }
        return res;
    }
}
