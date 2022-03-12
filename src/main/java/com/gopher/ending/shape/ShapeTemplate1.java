package com.gopher.ending.shape;

/**
 * @Title ShapeTemplate1
 * @Author fyw
 * @Date 2022-03-12 12:10
 * @Description 摆动类型
 */
public class ShapeTemplate1 {
    static class Code376{
        // 摆动序列，贪心
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length, idx = 0;
            // 类似c++中的unique，去掉相邻的重复元素（这里直接覆盖了没有移到数组末尾）
            for (int i = 0; i < n; i++) {
                int t = i;
                while (i + 1 < n && nums[i] == nums[i + 1]) i++;
                nums[idx++] = nums[t];
            }

            if (idx <= 2) return idx;
            int res = 2;
            for (int i = 1; i + 1 < idx; i++) {
                int a = nums[i - 1], b = nums[i], c = nums[i + 1];
                if (b > a && b > c || b < a && b < c) res++;
            }
            return res;
        }
    }
    static class Code942{
        // 增减字符串匹配，贪心
        public int[] diStringMatch(String s) {
            // 思维题，对于0-n 若遇到为I则将最小的值0填入，后面的数填什么都 可以 1-n
            // 若为D则填入n，则后面的数填什么都可以0-n-1。 所以这两种情况可以递归去处理后面的情况。
            // 这里使用l,r两个指针，每次缩小区间即可。
            int j = 0;
            int l = 0;
            int r = s.length();
            int[] res = new int[r + 1];
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == 'I') res[j++] = l++;
                else res[j++] = r--;
            }
            res[j] = r;
            return res;
        }
    }
}
