package com.gopher.leetcode.types.structure.monotonous_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Title Template2
 * @Author fyw
 * @Date 2022-03-04 8:52
 * @Description
 */
public class Template1 {
    static class Code84{

    }
    static class Code1081{

    }

    static class Code2104{
        // 子数组中最大元素和最小元素的差值求和，每个nums[i]成为最大值的次数和成为最小值的次数抵消求和
        // 统计每个nums[i]成为区间最值的次数，最大值：
        // 找到nums[i]左右最近一个不满足「小于等于nums[i]」的位置，记其为p和q。此时区间左端点共有i−p个选择，区间右端点共有q−i个选择，根据乘法原理，区间个数为(i - p)*(q - i)个；
        public long subArrayRanges(int[] nums) {
            long[] max=get(nums,false);
            long[] min=get(nums,true);
            long res=0;
            for (int i = 0; i < nums.length; i++) {
                res+=(max[i]-min[i])*nums[i];
            }
            return res;
        }
        public long[] get(int[] nums,boolean isMin){
            Deque<Integer> deque=new ArrayDeque<>();
            int[] left=new int[nums.length];
            int[] right=new int[nums.length];
            // 找区间左端点
            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty()&&(isMin?nums[deque.peekLast()]>=nums[i]:nums[deque.peekLast()]<=nums[i])){
                    deque.pollLast();
                }
                left[i]=deque.isEmpty()?-1:deque.peekLast();
                deque.addLast(i);
            }
            deque.clear();
            // 找区间右端点
            // 由于nums[i]存在相同元素，因此上述两边均取等号的做法会导致某些区间被重复计算，因此我们可以令最近右端点的部分不取等号，确保区间统计不重不漏。
            for (int i = nums.length-1; i >= 0; i--) {
                while (!deque.isEmpty()&&(isMin?nums[deque.peekLast()]>nums[i]:nums[deque.peekLast()]<nums[i])){
                    deque.pollLast();
                }
                right[i]=deque.isEmpty()?nums.length:deque.peekLast();
                deque.addLast(i);
            }
            long[] ans=new long[nums.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i]= (i - left[i]) * 1L * (right[i] - i);
            }
            return ans;
        }
    }
}
