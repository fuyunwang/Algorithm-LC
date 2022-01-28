package com.gopher.leetcode;

/**
 * @Title Code1095
 * @Author fyw
 * @Date 2022/1/28 15:50
 * @Description: 山脉数组中查找目标值
 */
public class Code1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n=mountainArr.length();
        int l=0,r=n-1;
        while(l<r){
            int mid = l+r>>1;
            if(mountainArr.get(mid)>mountainArr.get(mid+1)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        int M=r;  // 记录峰值
        l=0;
        r=M;
        // 左侧查找
        while(l<r){
            int mid=l+r>>1;
            if(mountainArr.get(mid)>=target){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        if(mountainArr.get(r)==target){
            return r;
        }
        l=M+1;
        r=n-1;
        // 右侧查找
        while(l<r){
            int mid = l+r>>1;
            if(mountainArr.get(mid)<=target){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        if(mountainArr.get(r)==target){
            return r;
        }
        return -1;
    }
}

interface MountainArray {
    public int get(int index);
    public int length();
}
