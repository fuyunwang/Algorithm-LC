package com.gopher.leetcode.types.sort.quick;

/**
 * @Title Code905
 * @Author fyw
 * @Date 2022/4/28 10:19
 * @Description:
 */
public class Code905 {
    public int[] sortArrayByParity(int[] nums) {
        int l=-1,r=nums.length-1;
        int cur=l+1,more=r;
        while (cur<more){
            if ((nums[cur]&1)==0){
                swap(nums,++l,cur++);
            }else if((nums[cur]&1)!=0){
                swap(nums,--more,cur);
            }else{
                cur++;
            }
        }
        swap(nums,r,more);
        return nums;
    }
    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
