package com.gopher.leetcode.types.array;

import java.util.*;

/**
 * @Title Template4
 * @Author fyw
 * @Date 2022-03-05 18:25
 * @Description 二分、山脉数组
 */
public class Template4 {

    static class Code1095{
        interface MountainArray {
            public default int get(int index){
                return 0;
            }
            public default int length() {
                return 0;
            }
        }
        public int findInMountainArray(int target, MountainArray mountainArr) {
            // 二分要考虑二段性，本题的二段性在于峰值数据左侧始终满足 ai+1> ai，右侧始终满足ai+1<ai
            int l=0,r=mountainArr.length()-1;
            while (l<r){
                int mid=l+((r-l)>>1);
                if (mountainArr.get(mid)>mountainArr.get(mid+1)){
                    r=mid;
                }else{
                    l=mid+1;
                }
            }
            // 左侧升序
            int l1=0,r1=r;
            while (l1<r1){
                int mid=l1+((r1-l1)>>1);
                if (mountainArr.get(mid)>=target){
                    r1=mid;
                }else{
                    l1=mid+1;
                }
            }
            if (mountainArr.get(r1)==target){
                return r1;
            }
            //右侧降序
            int l2=r,r2=mountainArr.length()-1;
            while (l2<r2){
                int mid=l2+((r2-l2+1)>>1);
                if (mountainArr.get(mid)>=target){
                    l2=mid;
                }else{
                    r2=mid-1;
                }
            }
            if (mountainArr.get(r2)==target){
                return r2;
            }
            return -1;
        }
    }

    static class Code747{
        // 找数组中的最大值和次大值
        public int dominantIndex(int[] nums) {
            int max = Integer.MIN_VALUE, less = 0, idx = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    less = max;
                    max = nums[i];
                    idx = i;
                } else if (nums[i] > less) {
                    less = nums[i];
                }
            }
            return max >= 2 * less ? idx : -1;
        }
    }

    static class Code845{
        // 数组中的最长山脉、类似合唱队形
        public int longestMountain(int[] arr) {
            /**
             * 递推
             */
            // 1 暴力解法是枚举所有的山脉顶点1-n-1，然后在左，右两侧找满足条件的小于cur的数的数量，且要连续。  on2会超时。
            // 2 根据题意，对每个点i 只需要找到左，右两侧第一个比其大的位置l, r，单调栈可以在on时间内找到左，右第一个比当前位置大或小的位置。(但是不能保证数是单调的)
            // 3 ldp[i]表示以i为山顶的左侧的长度，若ai > ai-1则dp[i]=dp[i-1] + 1否则dp[i]=1;
            Stack<Integer> lst = new Stack<>();
            Stack<Integer> rst = new Stack<>();
            int[] ldp = new int[arr.length];
            Arrays.fill(ldp, 1);
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > arr[i - 1]) ldp[i] = ldp[i - 1] + 1;
            }

            int[] rdp = new int[arr.length];
            Arrays.fill(rdp, 1);
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1]) rdp[i] = rdp[i + 1] + 1;
            }
            int res = 0;
            for (int i = 0; i < arr.length; i++) {
                // 左右都>1才能形成山脉，则累加计算，否则为0
                if (ldp[i] > 1 && rdp[i] > 1) res = Math.max(res, rdp[i] + ldp[i] - 1);
            }
            return res;

        }
    }
}
