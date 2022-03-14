package com.gopher.ending.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title BitCalculate
 * @Author fyw
 * @Date 2022-03-14 15:41
 * @Description 二进制计算
 */
public class BitCalculate {
    static class Code403{
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> res=new ArrayList<>();

            for (int i = 0; i < 1<<10; i++) { // 一共有10个位置，枚举所有可能时间
                int sum=0;
                for(int j=0;j<10;j++){
                    if ((i>>j&1)==1){
                        sum++;
                    }
                }
                if (sum==turnedOn){ // 如果当前时间下二进制表示的1的个数等于要求
                    int a=i>>6; // 取高位即小时
                    int b=i&63; // 取低位即分钟
                    if (a<12&&b<60){
                        String cur=String.format("%d:%02d",a,b);
                        res.add(cur);
                    }
                }
            }
            return res;
        }
    }
}