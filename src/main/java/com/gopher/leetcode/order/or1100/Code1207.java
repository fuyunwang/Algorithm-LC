package com.gopher.leetcode.order.or1100;
import java.util.*;
/**
 * @Title Code1207
 * @Author fyw
 * @Date 2022/11/18 11:26
 * @Description 独一无二的出现次数
 */
public class Code1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer value :  map.values()) {
            if(set.contains(value))
                return false;
            set.add(value);
        }
        return true;
    }
}
