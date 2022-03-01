package com.gopher.leetcode.types.sort.merge;

/**
 * @Title ReversePairs
 * @Author fyw
 * @Date 2022/1/25 13:06
 * @Description:
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        if (nums==null||nums.length==0)
            return 0;
        return process(nums,0,nums.length-1);
    }

    private int process(int[] nums, int L, int R) {
        if (L==R){      // 不构成逆序对
            return 0;
        }
        int mid=L+((R-L)>>1);
        return process(nums,L,mid) + process(nums,mid+1,R) + merge(nums,L,mid,R);
    }

    private int merge(int[] nums, int l, int mid, int r) {
        int[] help=new int[r-l+1];
        int p1=l;
        int p2=mid+1;
        int index=0;
        int res=0;
        for (;p1<=mid&&p2<=r;){
            if (nums[p1]<=nums[p2]){
                help[index++]=nums[p2++];
            }else{
                res+=(r-p2+1);
                help[index++]=nums[p1++];
            }
        }
        for (;p1<=mid;){
            help[index++]=nums[p1++];
        }
        for (;p2<=r;){
            help[index++]=nums[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            nums[l+i]=help[i];
        }
        return res;
    }

}
