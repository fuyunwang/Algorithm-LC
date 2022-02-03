package com.gopher.leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Title Code146
 * @Author fyw
 * @Date 2022/2/3 19:49
 * @Description: LRU算法
 */
public class Code146 {

    class LRUCache {
        private int capacity;
        private Map<Integer,Integer> map=new LinkedHashMap<>(); // 这是一个能够保证插入顺序的map
        public LRUCache(int capacity) {
            this.capacity=capacity;
        }

        public int get(int key) {
            if (map.keySet().contains(key)){
                int value=map.get(key);
                map.remove(key);
                map.put(key,value); // 配合LinkedHashMap实现顺序
                return value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.keySet().contains(key)){
                map.remove(key);
            }else if (map.size()==capacity){
                // 把最头部的删除
                final Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                iterator.next();
                iterator.remove();
            }
            map.put(key,value);
        }
    }

}
