package com.gopher.leetcode.order.or300;

import java.util.*;

/**
 * @Title Code380
 * @Author fyw
 * @Date 2022/2/9 14:05
 * @Description:
 */
public class Code380 {

    class RandomizedSet {

        Map<Integer, Integer> hash; // 维护值和list索引的映射
        List<Integer> nums;
        Random rand = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {
            hash = new HashMap<>();
            nums = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int x) {
            if (!hash.containsKey(x)) {
                nums.add(x);
                hash.put(x, nums.size() - 1);
                return true;
            }
            return false;

        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int x) {
            if (hash.containsKey(x)) {
                int y = nums.get(nums.size() - 1);
                int px = hash.get(x);
                nums.set(px, y);        // 注意换到最后一个位置，类似LRU
                hash.put(y, px);
                nums.remove(nums.size() - 1);
                hash.remove(x);
                return true;
            }
            return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }
}
