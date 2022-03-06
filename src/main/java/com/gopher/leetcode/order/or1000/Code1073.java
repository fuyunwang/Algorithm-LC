package com.gopher.leetcode.order.or1000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code1073
 * @Author fyw
 * @Date 2022-03-06 14:13
 * @Description
 */
public class Code1073 {
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
