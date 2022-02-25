package com.gopher.leetcode.order.or700;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Title Code705
 * @Author fyw
 * @Date 2022/2/9 13:52
 * @Description: 设计哈希集合
 * 哈希值映射到数组索引，对应数组元素为链表
 */
public class Code705 {
    class MyHashSet {
        private static final int BASE = 769;
        private LinkedList[] data;

        /** Initialize your data structure here. */
        public MyHashSet() {
            data = new LinkedList[BASE];
            for (int i = 0; i < BASE; ++i) {
                data[i] = new LinkedList<Integer>();
            }
        }

        public void add(int key) {
            int h = hash(key);
            Iterator<Integer> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Integer element = iterator.next();
                if (element == key) {
                    return;
                }
            }
            data[h].offerLast(key);
        }

        public void remove(int key) {
            int h = hash(key);
            Iterator<Integer> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Integer element = iterator.next();
                if (element == key) {
                    data[h].remove(element);
                    return;
                }
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int h = hash(key);
            Iterator<Integer> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Integer element = iterator.next();
                if (element == key) {
                    return true;
                }
            }
            return false;
        }

        private int hash(int key) {
            return key % BASE;
        }
    }
}
