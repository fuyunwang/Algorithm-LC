package com.gopher.leetcode.types.simulation;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Title BitCalculate
 * @Author fyw
 * @Date 2022-03-05 19:56
 * @Description 位运算
 */
public class BitCalculate {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res=new ArrayList<>();
        while (label>0){
            res.add(label);
            label>>=1;
        }
        Collections.reverse(res);
        // 对于指定位置异或全1，即2^i-1
        for (int i=res.size()&1;i<res.size();i+=2){
            res.set(i,res.get(i)^((1<<i)-1));
        }
        return res;
    }
    static class Code1290{
        // 二进制链表（二进制转10进制）转整数
        public int getDecimalValue(ListNode head) {
            if(head==null){
                return 0;
            }
            int res=0;
            while(head!=null){
                res=(res<<1)+head.val;
                head=head.next;
            }
            return res;
        }
    }
    static class Code504{
        // 十进制转7进制
//        public String convertToBase7(int num) {
//            return Integer.toString(num,7);
//        }
        public String convertToBase7(int num) {
            if(num == 0) return "0";
            StringBuilder sb=new StringBuilder();
            boolean flag=num<0;
            num=Math.abs(num);
            while (num!=0){
                sb.insert(0,num%7);
                num/=7;
            }
            if (flag)
                sb.insert(0,'-');
            return sb.toString();
        }

        /*
         * public String convertToBase7(int num) {
         *         if(num<0){
         *             return "-"+convertToBase7(-1*num);
         *         }
         *         if(num<7){
         *             return ""+num;
         *         }
         *         return convertToBase7(num/7)+String.valueOf(num%7);
         * }
         */
    }
}
