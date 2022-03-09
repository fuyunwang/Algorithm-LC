package com.gopher.leetcode.types.greed;
import java.util.*;
/**
 * @Title Template2
 * @Author fyw
 * @Date 2022-03-08 20:14
 * @Description
 */
public class Template2 {
    static class Code757{

    }
    static class Code768{
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length;
            int[] copy = Arrays.copyOf(arr, n);
            Arrays.sort(copy);
            int res = 0, totalDiff = 0;
            for (int i = 0; i < n; i++) {
                totalDiff += arr[i] - copy[i];
                if (totalDiff == 0) {
                    res++;
                }
            }
            return res;
        }

    }
    static class Code769{
        public int maxChunksToSorted(int[] arr) {
            // 上一题的简化版，
            int res = 0;
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
                if (max == i) res++;
            }
            return res;
        }
    }

    static class Code1029{
        public int twoCitySchedCost(int[][] costs) {
            Arrays.sort(costs, (a, b) -> a[0] - a[1] - (b[0] - b[1]));
            int n = costs.length/2;
            int res = 0;
            for (int i = 0; i < n; i++ ) res += costs[i][0];
            for (int i = n; i < n*2; i++) res += costs[i][1];
            return res;
        }
    }
}
