package com.gopher.leetcode.order.or20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title Code18
 * @Author fyw
 * @Date 2022/1/22 20:07
 * @Description: 四数之和
 */
public class Code18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1, u = nums.length - 1; k < u; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    while (k < u - 1 && nums[i] + nums[j] + nums[k] + nums[u - 1] >= target) u--;
                    if (nums[i] + nums[j] + nums[k] + nums[u]==target){
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[u])));
                    }
                }
            }
        }
        return result;
    }
}
