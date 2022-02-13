package com.gopher.leetcode.order.or400;

import java.util.*;

/**
 * @Title Code496
 * @Author fyw
 * @Date 2022/2/9 13:54
 * @Description:
 */
public class Code496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = nums2.length-1; i >= 0; i--) {
            while (!stack.isEmpty()&&nums2[stack.peek()]<nums2[i]) stack.pop();
            if (stack.isEmpty()) {
                map.put(nums2[i],-1);
            } else{
                map.put(nums2[i],nums2[stack.peek()]);
            }
            stack.push(i);
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(map.get(nums1[i]));
        }
        int[] res=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}
