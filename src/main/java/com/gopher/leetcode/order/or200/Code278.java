package com.gopher.leetcode.order.or200;

/**
 * @Title Code278
 * @Author fyw
 * @Date 2022/2/8 21:22
 * @Description: 第一个错误的版本
 */
public class Code278 {
    abstract class VersionControl{
        boolean isBadVersion(int version) {
            return false;
        }
    }
    class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int l=0,r=n;
            while (l<r){
                int mid=l+((r-l)>>1);
                if (isBadVersion(mid)){
                    r=mid;
                }else{
                    l=mid+1;
                }
            }
            return l;
        }
    }
}
