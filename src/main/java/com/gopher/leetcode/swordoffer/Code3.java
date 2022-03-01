package com.gopher.leetcode.swordoffer;

import com.gopher.leetcode.types.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code3
 * @Author fyw
 * @Date 2022-03-01 20:51
 * @Description  从尾到头打印链表
 */
public class Code3 {
    List<Integer> list=new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        reverse(head);
        int[] res=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }
    
    void reverse(ListNode head){
        if (head==null)
            return;
        reverse(head.next);
        list.add(head.val);
    }

    static class Code3_2{
        int[] res;
        int i;//全局变量
        public int[] reversePrint(ListNode head) {

            recur(head,0);//递归函数调用
            return res;
        }
        void recur(ListNode head,int count) {
            if(head == null)
            {//递归终止条件
                res = new int[count];
                i = count-1;
                return;
            }
            recur(head.next,count+1);
            res[i-count] =  head.val; //这里的i-count是重点
        }
    }
}
