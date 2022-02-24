package com.gopher.leetcode.order.or40;

/**
 * @Description: 二分查找
 * @Author: FuyunWang
 * @Date: 2022/1/2 17:01
 */
public class DichotomyArray {
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
                    r=mid;      // if决定了要查询的值可能等于mid，可能小于mid。所以r=mid
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
