package com.gopher.leetcode.types.strs;

import java.util.*;

/**
 * @Title Template2
 * @Author fyw
 * @Date 2022-03-06 20:44
 * @Description
 */
public class Template2 {
    static class Code763{
        // 划分字母区间
        public List<Integer> partitionLabels(String s) {
            List<Integer> res = new ArrayList<>();
            // 首先记录每一字符的最后索引
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), i);
            }

            int p = 0;
            while (p < s.length()) {
                int index = map.get(s.charAt(p));
                int maxindex = index;
                for (int j = p; j <= index; j++) {
                    if (map.get(s.charAt(j)) > maxindex) {  // 这段范围内其他字符的最大索引可以增加区间范围
                        maxindex = map.get(s.charAt(j));    // 更新最大区间的索引
                        if (maxindex > index) index = maxindex; // index始终作为边界值
                    }
                }

                res.add(maxindex - p+1); // 最左索引和最右索引的数据长度
                p = maxindex + 1;
            }
            return res;
        }
    }
}
