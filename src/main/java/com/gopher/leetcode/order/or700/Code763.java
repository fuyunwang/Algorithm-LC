package com.gopher.leetcode.order.or700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Title Code763
 * @Author fyw
 * @Date 2022/2/8 21:56
 * @Description: 划分字母区间
 */
public class Code763 {
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
                    maxindex = map.get(s.charAt(j));
                    if (maxindex > index) index = maxindex;
                }
            }

            res.add(maxindex - p + 1); // 最左索引和最右索引的数据长度
            p = maxindex + 1;
        }
        return res;
    }
}
