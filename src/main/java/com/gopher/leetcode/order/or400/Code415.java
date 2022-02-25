package com.gopher.leetcode.order.or400;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code415
 * @Author fyw
 * @Date 2022/2/9 12:34
 * @Description: 高精度加法
 */
public class Code415 {
    public String addStrings(String a, String b) {
        List<Integer> A = new ArrayList<Integer>();
        List<Integer> B = new ArrayList<Integer>();
        for (int i = a.length() - 1; i >= 0; i -- ) A.add(a.charAt(i) - '0');
        for (int i = b.length() - 1; i >= 0; i -- ) B.add(b.charAt(i) - '0');

        List<Integer> C = add(A, B);
        StringBuilder sb=new StringBuilder();
        for(int i:C){
            sb.append(i);
        }
        return sb.reverse().toString();
    }
    public List<Integer> add(List<Integer> A,List<Integer> B )
    {
        if (A.size()<B.size()) return add(B,A);
        int t = 0;
        for (int i = 0; i < A.size(); i ++ )
        {
            t += A.get(i);
            if (i < B.size()) t += B.get(i);
            A.set(i, t % 10);
            t /= 10;
        }
        if (t!=0) A.add(t);
        return A;
    }
}
