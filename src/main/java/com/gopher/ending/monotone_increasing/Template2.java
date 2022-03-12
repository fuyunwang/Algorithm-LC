package com.gopher.ending.monotone_increasing;

import java.util.*;

/**
 * @Title Template2
 * @Author fyw
 * @Date 2022/3/12 23:57
 * @Description: 下一个排列
 */
public class Template2 {
    static class Code670{
        public int maximumSwap(int num) {
            LinkedList<Integer> q=new LinkedList<>();
            while(num!=0){
                q.addFirst(num%10);
                num/=10;
            }

            int a[]=new int[q.size()];
            for(int i=0;i<q.size();i++) a[i]=q.get(i);  // 正序存储

            for(int i=0;i<a.length;i++){
                //从前向后找最大值
                int idx=i,max=a[i];
                for(int j=i+1;j<a.length;j++)
                    if(a[j]>=max){
                        max=a[j];
                        idx=j;
                    }
                if(max==a[i]) continue;
                if(idx!=i){
                    int temp=a[i];
                    a[i]=a[idx];
                    a[idx]=temp;
                    break;
                }
            }

            int res=0;
            for(int i=0;i<a.length;i++) res=res*10+a[i];

            return res;
        }

    }
}
