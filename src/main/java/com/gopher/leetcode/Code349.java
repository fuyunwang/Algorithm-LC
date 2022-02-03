package com.gopher.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title Code349
 * @Author fyw
 * @Date 2022/2/3 14:09
 * @Description: 两个数组的交集
 */
public class Code349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0){
            return new int[0];
        }
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }
        int[] res=new int[set2.size()];
        int index=0;
        for (Integer i:set2) {
            res[index++]=i;
        }
        return res;
    }
}
