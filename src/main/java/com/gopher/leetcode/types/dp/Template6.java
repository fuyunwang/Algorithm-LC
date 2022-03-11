package com.gopher.leetcode.types.dp;

import java.util.*;

/**
 * @Title Template6
 * @Author fyw
 * @Date 2022-03-09 19:22
 * @Description 数位DP
 */
public class Template6 {
    static class Code600{
        // 求有多少个在0-n的数中，二进制表示下有多少个数不包含连续1
        public int findIntegers(int num) {
            //取出二进制的每一位
            LinkedList<Integer> list=new LinkedList<>();
            while(num!=0){
                list.addLast(num%2);
                num/=2;
            }
            int f[][]=new int[2][list.size()+1];
            f[0][1]=f[1][1]=1;
            for(int i=2;i<=list.size();i++){
                //最高位为0的话，次高位可以为1或0;最高位为1，次高位为0
                f[0][i]=f[0][i-1]+f[1][i-1];
                f[1][i]=f[0][i-1];
            }

            int res=0;
            for(int i=list.size()-1,last=0;i>=0;i--){
                int val=list.get(i);
                //如果当前位为1的话代表：小于这一位的都可以
                if(val==1){
                    res+=f[0][i+1];
                    if(last==1) return res;//不能有两个连续的1
                }
                last=val;
            }
            return res+1;
        }

    }
    static class Code1012{
        int P(int a, int b) {
            int res = 1;
            for (int i = a, j = 0; j < b; i --, j ++ )
                res *= i;
            return res;
        }
        public int numDupDigitsAtMostN(int n) {
            //数位dp或数位统计（统计满足要求的数字有多少个）
            //补集思想：总数-不含重复数字的正整数个数
            //画一棵树
            //f(n) 1~n之间每一位都不重复的数字个数
            LinkedList<Integer> nums = new LinkedList();
            int res = n;
            while (n > 0) {
                nums.offerLast(n % 10);
                n /= 10;
            }
            boolean[] st = new boolean[10];
            for (int i = 1; i < nums.size(); i++)
                res -= 9 * P(9, i - 1);
            res -= (nums.peekLast() - 1) * P(9, nums.size() - 1);

            st[nums.peekLast()] = true;
            for (int i = nums.size() - 2; i >= 0; i--) {
                int x = nums.get(i);
                for (int j = 0; j < x; j++)
                    if (!st[j])
                        res -= P(10 - (nums.size() - i), i);

                if (st[x]) return res;
                st[x] = true;
            }

            return res - 1;
        }
    }
}
