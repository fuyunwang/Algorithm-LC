package com.gopher.leetcode.types.math;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Title BigNumber
 * @Author fyw
 * @Date 2022-03-06 14:14
 * @Description
 */
public class BigNumber {
    static class Code989{
        // 高精度加法
        public List<Integer> addToArrayForm(int[] num, int k) {
            List<Integer> res=new ArrayList<>();
            for (int i=num.length-1;i>=0;i--){
                int sum=num[i]+k%10;
                k/=10;
                if (sum>=10){
                    sum-=10;
                    k++;
                }
                res.add(sum);
            }
            for (;k>0;k/=10){
                res.add(k%10);
            }
            Collections.reverse(res);
            return res;
        }
    }
    static class Code1073{
        public int[] addNegabinary(int[] arr1, int[] arr2) {
           Deque<Integer> temp=new ArrayDeque<>();
            for (int i = arr1.length-1,j=arr2.length-1,a=0,b=0,c=0;
                 i>=0||j>=0||a!=0||b!=0||c!=0;
                 i--,j--) {
                if (a==1&&b==2)
                    a=b=0;
                c=b;
                b=a;
                a=0;
                if (i>=0)
                    c+=arr1[i];
                if (j>=0)
                    c+=arr2[j];
                temp.offerFirst(c&1);
                c>>=1;
                a+=c;
                b+=c;
            }
            while (temp.size()>1&&temp.peek().intValue()==0){
                temp.pollFirst();
            }
            return temp.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
