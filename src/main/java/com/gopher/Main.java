package com.gopher;

import com.gopher.leetcode.types.structure.tree.TreeNode;

import java.util.*;

/**
 * @Title Main
 * @Author fyw
 * @Date 2022-02-24 20:27
 * @Description
 */
public class Main {
    public static void main(String[] args) {
//        String s=
//                "42/47/51/53/61/68/72/97/197/114/134/135/166/188/214/218/221/233/234/237/238/240/241/257/258/260/264/268/273/279/287/292/307/309/310/315/329/337/357/365/378/390/391/395/399/400";
//        String[] split = s.split("/");
//        System.out.println(split.length);
//        System.out.println(Arrays.toString(split));
        System.out.println(Math.sqrt(5));
    }

    public int maximumDifference(int[] nums) {
//        int res=-1;
//        for (int i = 0; i < nums.length; i++) {
//            int j=i+1;
//            while (j<nums.length){
//                if (nums[j]>nums[i]){
//                    res=Math.max(res,nums[j]-nums[i]);
//                }
//                j++;
//            }
//        }
//        return res;
        int prev=nums[0],res=-1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>prev){
                res=Math.max(res,nums[i]-prev);
            }else{
                prev=nums[i];// 找到了更小的前一个元素，后续的元素要取得最大差值那么之前的元素就可以不考虑了，所以直接更新
            }
        }
        return res;
    }

    static class Prac{
    }

}
