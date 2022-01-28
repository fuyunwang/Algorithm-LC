package com.gopher.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Title Code179
 * @Author fyw
 * @Date 2022/1/28 12:04
 * @Description: 最大数，重写排序规则
 */
public class Code179 {
    public String largestNumber(int[] nums) {
        String[] res=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]);
        }
        String s=sb.toString();
        if (s.charAt(0)=='0'){
            s="0";
        }
        return s;
    }
}
