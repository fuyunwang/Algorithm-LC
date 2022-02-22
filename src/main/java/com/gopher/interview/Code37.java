package com.gopher.interview;

/**
 * @Title Code37
 * @Author fyw
 * @Date 2022-02-22 11:01
 * @Description 数组中出现次数超过一半的数字
 */
public class Code37 {
    public int moreThanHalfNum_Solution(int[] nums) {
        int res = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (res == nums[i]) {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    cnt = 1;
                    res = nums[i];
                }
            }
        }
        return res;
    }
}
