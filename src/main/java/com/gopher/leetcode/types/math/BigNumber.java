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
            List<Integer> list1=new ArrayList<>();
            List<Integer> list2=new ArrayList<>();
            for (int a1: arr1){
                list1.add(a1);
            }
            for(int a2:arr2){
                list2.add(a2);
            }

            Collections.reverse(list1);
            Collections.reverse(list2);

            LinkedList<Integer> res=new LinkedList<>();
            for (int i = 0, a=0,b=0,c=0; i < list1.size()||i<list2.size()||a!=0||b!=0; i++) {
                // a表示最前位进位，b表示次前位进位，c表示当前位
                if (a==1&&b==2)     // b进了两次，a进了一次
                    a=b=0;
                c=b;
                b=a;
                a=0;
                if (i<list1.size()) c+=list1.get(i);
                if (i<list2.size()) c+=list2.get(i);
                res.add(c&1);
                c>>=1;
                a+=c;   // 加到第k+2位的进位
                b+=c;   // 加到第k+1位的进位
            }
            Collections.reverse(res);
            int j=0;
            while (j<res.size()-1&& res.get(j)==0){
                res.pollFirst();
            }
            int[] r=new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                r[i]=res.get(i);
            }
            return r;
        }
    }
}
