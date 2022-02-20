package com.gopher.coding;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code2816
 * @Author fyw
 * @Date 2022/2/14 21:07
 * @Description:
 */
public class DoublePointer {
    class LeetCode03{
        public int lengthOfLongestSubstring(String s) {
            int n=s.length();
            Map<Character, Integer> map = new HashMap<>();
            int res = 0;
            for(int i = 0, j = 0; i < n;i++) {
                char c=s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1); //nums[i]不存在返回0
                while(map.get(c) > 1) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                    j++;
                }
                res = Math.max(res, i-j+1);
            }
            return res;
        }
    }

}
