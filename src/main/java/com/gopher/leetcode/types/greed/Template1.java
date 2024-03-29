package com.gopher.leetcode.types.greed;

import java.util.*;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-06 20:38
 * @Description
 */
public class Template1 {
    static class Code826 {
        class Task {
            int difficult;
            int profit;

            public Task(int difficult, int profit) {
                this.difficult = difficult;
                this.profit = profit;
            }
        }

        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            // 1 每个工人都是独立的，即对每个工人找到其能最接受的最大难度的工作。暴力法是对每个工人，枚举每个难度。on2会超时。
            // 2 优化，可以排序，对任务难度，工人排序。对于工人i,若选择了最能接受的难度j后，则对于工人i+1,其能接受的难度肯定是大于等于j的。因为工人是按难度从小到大排序的。
            // 3 所以遍历工人i, 则j是单调递增的。不需要每次都遍历所有难度。具有单调性，所以可以使用双指针来做。
            // 4 可以用任务类来存工作，及其收益
            List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < difficulty.length; i++) {
                tasks.add(new Task(difficulty[i], profit[i]));
            }
            // 难度从小到大排序
            Collections.sort(tasks, (o1, o2) -> o1.difficult - o2.difficult);
            Arrays.sort(worker);
            // 一个指针i遍历每个工人 ，另一个指针j单调向后遍历任务
            int j = 0;
            int res = 0;
            int pMax = 0; // 缓存当前最大的利润
            for (int i = 0; i < worker.length; i++) {
                // 找到该工人最能接受的最大难度
                while (j < tasks.size() && worker[i] >= tasks.get(j).difficult) {
                    pMax = Math.max(pMax, tasks.get(j).profit);
                    j++;
                }
                res += pMax;
            }
            return res;
        }
    }

    static class Code1090 {
        /**
         * 有一些物品，每个物品都有一个价值value以及该物品的对应编号label。
         * 我们需要从中拿出来num_wanted个物品，希望物品价值最大，并且每一类物品不超过use_limit个，求最大价值
         * 标签代表种类，种类下面有不同价值的商品，我们先混起来，按照价值排序，然后看是否超出了拿的预期
         */
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            PriorityQueue<Information> queue = new PriorityQueue<>((p1, p2) -> p2.value - p1.value); // 贪心拿，从价值最大的物品开始取
            for (int i = 0; i < values.length; i++) {
                queue.offer(new Information(labels[i], values[i]));
            }
            // 记录一下每一种类已经拿了多少个
            Map<Integer, Integer> map = new HashMap<>();

            int res = 0;
            while (!queue.isEmpty() && numWanted > 0) {
                Information poll = queue.poll();
                map.put(poll.label, map.getOrDefault(poll.label, 0) + 1);
                if (map.get(poll.label) > useLimit) {
                    continue;// 这一种类的就弹出一个
                }
                res += poll.value;
                --numWanted;
            }

            return res;
        }

        class Information {
            int label;
            int value;

            public Information(int label, int value) {
                this.label = label;
                this.value = value;
            }

            @Override
            public boolean equals(Object o) {
                if (o == null)
                    return false;
                if (o == this)
                    return true;
                if (o instanceof Information) {
                    Information cur = (Information) o;
                    return cur.label == this.label && cur.value == this.value;
                }
                return false;
            }

            @Override
            public int hashCode() {
                int res = 17;
                res = res * 31 + this.label;
                res = res * 31 + this.value;
                return res;
            }
        }
    }

    static class Code1054 {
        // 依次从最多的元素开始取使得所有元素交错，类似767题目
        public int[] rearrangeBarcodes(int[] barcodes) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < barcodes.length; i++) {
                map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
            }

            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                queue.offer(new int[]{entry.getKey(), entry.getValue()});
            }

            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int[] other = queue.poll();
                list.add(poll[0]);
                map.put(poll[0], map.getOrDefault(poll[0], 0) - 1);
                if (map.get(poll[0]) > 0) {
                    queue.offer(new int[]{poll[0], map.get(poll[0])});
                }
                if (other != null) {
                    list.add(other[0]);
                    map.put(other[0], map.getOrDefault(other[0], 0) - 1);
                    if (map.get(other[0]) > 0) {
                        queue.offer(new int[]{other[0], map.get(other[0])});
                    }
                }
            }

            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

    static class Code1053 {
        // 保证字典序小于当前排列的最大的排列，贪心从数组尾部开始考虑找到非升序的开始位置
        public int[] prevPermOpt1(int[] arr) {
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1]) {
                    int j = i + 1;
                    while (j < arr.length - 1 && arr[i] > arr[j + 1]) j++;
                    while (arr[j - 1] == arr[j])    // 如果有重复元素那么需要考虑第一个重复元素的交换
                        j--;
                    swap(arr, i, j);
                    return arr;
                }
            }
            return arr;
        }

        void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
