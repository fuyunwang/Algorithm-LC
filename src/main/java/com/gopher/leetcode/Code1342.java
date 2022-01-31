package com.gopher.leetcode;

/**
 * @Title Code1342
 * @Author fyw
 * @Date 2022/1/31 16:44
 * @Description:
 */
public class Code1342 {
    public int numberOfSteps(int num) {
        int step=0;
        while(num!=0){
            if(num%2==0){
                num>>=1;
            }else{
                num--;
            }
            step++;
        }
        return step;
    }
}
