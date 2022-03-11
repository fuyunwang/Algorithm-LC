package com.gopher.leetcode.types.structure.monotonous_stack;

import java.util.*;

/**
 * @Title Template2
 * @Author fyw
 * @Date 2022-03-04 8:52
 * @Description
 */
public class Template1 {
    static class Code84{

    }
    static class Code907{
        public int sumSubarrayMins(int[] arr) {
            // 1 关键在于转换：不要正向思考求每个子数组再求最小值累加。可以对每个元素i，求以其作为最小值时的会出现在多少个区间中。
            // 2 一个区间中可能会有多个值最小。为了避免重复可以约定前面的数最小。 枚举每个i，找到左边第一个比其小的数，右边第一个比其小的数。
            // 3 左边区间长度 llen 右边区间长度rlen, 则以i为最小值的 子数组数量是ilen * rlen 再乘以a[i]值，即为对答案的贡献。
            // 4 找左右 第一个比自己小的数可以 用单调栈。
            // 5 和84题思路基本上一样。只是最后计算方式不一样。
            Stack<Integer> st = new Stack<>();
            int n = arr.length;
            int[] left = new int[n];
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                    st.pop();
                }
                if (st.isEmpty()) left[i] = -1; // 若没有比自己小的数，则置为-1，可以认为是0前面的位置
                else left[i] = st.peek();
                st.push(i);
            }
            st.clear();
            int[] right = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                    st.pop();
                }
                if (st.isEmpty()) right[i] = n;
                else right[i] = st.peek();
                st.push(i);
            }
            long res = 0;
            for (int i = 0; i < n; i++) {
                res = (res + (long)arr[i] * (i - left[i]) * (right[i] - i)) % 1000000007;
            }
            return (int)res;
        }
    }
    static class Code1081{

    }

    static class Code735{
        // 行星碰撞
        public int[] asteroidCollision(int[] as) {
            Deque<Integer> stk = new ArrayDeque<>();
            for(int x: as){
                if(x > 0){
                    stk.push(x);                                                                // 全为正向
                }else{
                    while(stk.size() > 0 && stk.peek() > 0 && stk.peek() < -x) stk.pop();       // 一个正向一个逆向
                    if(stk.size() == 0 || stk.size() > 0 && stk.peek() < 0) stk.push(x);        // 全为逆向
                    else if(stk.size() > 0 && stk.peek() == -x) stk.pop();
                }
            }
            int[] res = new int[stk.size()];
            int k = stk.size() - 1;
            while(stk.size() > 0){
                res[k--] = stk.pop();
            }
            return res;
        }
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
