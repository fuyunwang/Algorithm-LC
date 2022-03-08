package com.gopher.leetcode.types.array;

/**
 * @Title Template4
 * @Author fyw
 * @Date 2022-03-05 18:25
 * @Description 二分
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
}
