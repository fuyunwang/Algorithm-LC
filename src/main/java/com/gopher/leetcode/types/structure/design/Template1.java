package com.gopher.leetcode.types.structure.design;

import java.util.*;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-09 22:11
 * @Description 设计题
 */
public class Template1 {
    static class Code981 {
        class TimeMap {
            /**
             * Initialize your data structure here.
             */
            HashMap<String, TreeMap<Integer, String>> hash;
            public TimeMap() {
                hash = new HashMap<>();
            }
            public void set(String key, String value, int timestamp) {
                if (!hash.containsKey(key)) {
                    hash.put(key, new TreeMap<>());
                }
                hash.get(key).put(timestamp, value);
            }
            public String get(String key, int timestamp) {
                if (!hash.containsKey(key)) return "";
                TreeMap<Integer, String> bst = hash.get(key);
                Integer pre = bst.floorKey(timestamp);
                if (pre == null || pre.intValue() > timestamp) return "";
                return bst.get(pre);
            }
        }
    }
}