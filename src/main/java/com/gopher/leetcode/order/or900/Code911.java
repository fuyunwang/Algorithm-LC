package com.gopher.leetcode.order.or900;

/**
 * @Title Code911
 * @Author fyw
 * @Date 2022/2/9 14:10
 * @Description:
 */
public class Code911 {
    // 0 <= persons[i] < persons.length，计数排序
    class TopVotedCandidate {
        int[] times;
        int[] win;
        public TopVotedCandidate(int[] persons, int[] times) {
            int n=persons.length;
            this.times=times;
            this.win=new int[n];        // 保存每个时刻获胜的人
            int[] sum = new int[n + 1]; // sum保存每一个人对一个的投票
            int maxVal=0,maxPerson=0;   // 定义当前最大的投票数和获得最多投票的人
            for (int i = 0; i < n; i++) {
                if (++sum[persons[i]]>=maxVal){
                    maxVal=sum[persons[i]];
                    maxPerson=persons[i];
                }
                win[i]=maxPerson;
            }

        }

        public int q(int t) {
            // 获得对应时刻下较小值里面的最大值，即t的左侧边界
            int l=0,r=times.length-1;
            while (l<r){
                int mid=l+r+1>>1;
                if (times[mid]<=t){
                    l=mid;
                }else{
                    r=mid-1;
                }
            }
            return win[l];
        }
    }
}
