package com.fuyunwang.bilibili.order.hot100;

/**
 * @Title Code169
 * @Author fyw
 * @Date 2022/5/22 21:21
 * @Description: 多数元素
 */
public class Code169 {
    public int majorityElement(int[] nums) {
        int r=0,c=0;
        for (int x:nums){
            if (c==0) {
                r=x;
                c=1;
            }else if (r==x){
                c++;
            }else{
                c--;
            }
        }
        return r;
    }
}
