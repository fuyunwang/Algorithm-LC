package com.gopher.leetcode.order.or1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Title Code1200
 * @Author fyw
 * @Date 2022/11/18 11:54
 * @Description
 */
public class Code1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        if (arr.length<2)
            return Collections.emptyList();
        Arrays.sort(arr);
        int mindiff=arr[1]-arr[0];
        for (int i = 1; i < arr.length; i++) {
            mindiff=Math.min(mindiff,arr[i]-arr[i-1]);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]-arr[i-1]==mindiff){
                ans.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return ans;
    }
}
