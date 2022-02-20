package com.gopher.leetcode.order.or40;

/**
 * @Description: 二分查找
 * @Author: FuyunWang
 * @Date: 2022/1/2 17:01
 */
public class DichotomyArray {
    // 左右闭区间，端点包含目标值循环取等号，更新过程左右指针不取中间索引这与闭区间定义也是一致的，值存在数组中左右边界相等有意义
    public int search1(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (nums[mid]<target){
                l=mid+1;
            }else if(nums[mid]>target){
                r=mid-1;
            }else{
                return mid;// 找到返回索引
            }
        }
        return -1;
    }
    // 左闭右开，值存在数组中左右边界相等无意义
    public int search(int[] nums, int target) {
        if(nums==null||nums.length<1){
            return -1;
        }
        int left = 0, right=nums.length;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid;
            }else{
                return mid;
            }
        }
        return -1;
    }
    // 左闭右开区间，左右端点相等是没有意义的所以不取等号，更新过程中开区间端点要取中间索引，值不存在数组中左右边界相等无意义
    public int search2(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if (nums[mid]>target){
                r=mid;
            }else if (nums[mid]<target){
                l=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    // 搜索左侧边界的二分搜索，值存在数组中左右边界相等有意义
    public int searchzuo(int[] nums,int target){
        if (nums==null||nums.length<1)
            return -1;
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (nums[mid]<target){
                l=mid+1;
            }else if(nums[mid]>target){
                r=mid-1;
            }else{
                r=mid-1; // 收缩右边界
            }
        }
        if (nums[l]!=target||l>=nums.length)
            return -1;
        return l;
    }
    // 搜索右侧边界的二分搜索，值存在数组中左右边界相等有意义
    public int searchyou(int[] nums,int target){
        if (nums==null||nums.length<1)
            return -1;
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (nums[mid]<target){
                l=mid+1;
            }else if (nums[mid]>target){
                r=mid-1;
            }else{
                l=mid+1; // 收缩左边界
            }
        }
        if (nums[r]!=target||r<0)
            return -1;
        return r;
    }

    class Wing{
        // 记录整数二分的模板
        int n;
        int[] q;
        int target;
        public void findLeftBorder(){
            // 给定数组 1 2 2 3 3 4 查找确定值的范围
            // 查找左侧边界
            int l=0, r=n-1;
            while (l<r){
                int mid = l+r>>1;
                if (q[mid]>=target){
                    r=mid;
                }else{
                    l=mid+1;
                }
            }
            System.out.println(l); // 查找到的左边界
            // 查找右边界
            l=0;r=n-1;
            while (l<r) {
                int mid = l + r + 1 >> 1;// 只有l=mid时才+1
                if (q[mid] <= mid) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            System.out.println(l); // 查找到的右边界
        }
    }
}
