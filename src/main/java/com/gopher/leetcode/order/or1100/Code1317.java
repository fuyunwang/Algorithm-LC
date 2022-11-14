package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1317
 * @Author fyw
 * @Date 2022/11/14 21:40
 * @Description
 */
public class Code1317 {
    public int[] getNoZeroIntegers(int n) {
        int[] res=new int[2];
        for (int i = 1; i <= n/2; i++) {
            if (check(i)&&check(n-i)){
                res[0]=i;
                res[1]=n-i;
                return res;
            }
        }
        return res;
    }

    boolean check(int n){
        while (n!=0){
            if (n%10==0)    // 表示含0
                return false;
            n/=10;
        }
        return true;
    }

}
