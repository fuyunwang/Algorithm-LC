package com.gopher.leetcode.order.or200;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Title Code253
 * @Author fyw
 * @Date 2022/2/8 22:03
 * @Description:
 * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
 * 返回 所需会议室的最小数量 。
 *
 * 示例 1：
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：2
 */
public class Code253 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null||intervals.length==0) return 0;
        // 按结束时间排序
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        // 按开始时间排序
        Arrays.sort(intervals,(i, j)->i[0]-j[0]);
        queue.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++) {
            int last = queue.peek(); // 最早结束的
            if(last <= intervals[i][0]) {
                // 可以腾出会议室
                queue.poll();
                // 修改时间
                queue.add(intervals[i][1]);
            } else {
                // 需要一个新的
                queue.add(intervals[i][1]);
            }

        }
        return queue.size();
    }
}
