package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1122
 * @Author fyw
 * @Date 2022/2/4 13:17
 * @Description: 数组的相对排序
 * 数据元素确定是在1000及之内，考虑计数排序
 */
public class Code1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 记录arr1中元素的个数
        int[] res=new int[arr1.length];
        int[] nums=new int[1001];
        int index=0;
        for (int i = 0; i < arr1.length; i++) {
            nums[arr1[i]]++;
        }
        for (int i = 0; i < arr2.length; i++) {
            while (nums[arr2[i]]>0){
                res[index++]=arr2[i];
                nums[arr2[i]]--;
            }
        }
        // 未在arr2中出现的元素要升序排序放在尾部
        // 直接计数，因为不出现的目前肯定是0，直接根据元素索引对应元素增加即可

        for (int i = 0; i < nums.length; i++) {
            while (nums[i]>0){
                res[index++]=i;
                nums[i]--;
            }
        }
        return res;
    }
}
