package com.gopher.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Title Code1033
 * @Author fyw
 * @Date 2022/2/6 20:45
 * @Description:
 * 使得数轴上三个点连续的最多和最少操作次数
 */
public class Code1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int num[] = {a,b,c};
        Arrays.sort(num);
        int ans[] = {0,0};
        if(num[0] + 2 == num[2]) return ans;
        if(num[0]+1 == num[1]){
            ans[0] = 1;
            ans[1] = num[2] - num[1] - 1;
        }else if(num[1] + 1 == num[2]){
            ans[0] = 1;
            ans[1] = num[1] - num[0] - 1;
        }else if(num[0]+2 == num[1] || num[1]+2==num[2]){
            ans[0] = 1;
            ans[1] = Math.max(num[2]-num[1],num[1]-num[0]);
        }
        else{
            ans[0] = 2;
            ans[1] = num[2]-num[1] + num[1]-num[0]-2;
        }
        return ans;
    }
}
