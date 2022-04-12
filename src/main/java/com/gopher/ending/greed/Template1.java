package com.gopher.ending.greed;

import java.util.*;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-12 12:48
 * @Description
 */
public class Template1 {


    static class Code955{
        public int minDeletionSize(String[] strs) {
            int n = strs.length ;
            int m = strs[0].length() ;
            int ret = 0 ;
            boolean [] f = new boolean[n] ;
            for (int i = 0; i < m ; ++i) {
                boolean flag = true ;
                for (int j = 1; j < n ; ++j) {
                    if (!f[j] && strs[j - 1].charAt(i) > strs[j].charAt(i)) {
                        flag = false;
                    }
                }
                if (!flag) {
                    ret++ ;
                } else {
                    for (int j = 1 ;j < n ; ++j) {
                        if (!f[j] && strs[j - 1].charAt(i) < strs[j].charAt(i)) {
                            f[j] = true ;
                        }
                    }
                }
            }
            return ret ;
        }
    }

    static class Code857{

    }

    static class Code1053{
        // 交换一次的先前排列，本质是求小于当前数的最大数同时每一位数都是对应的
        // 思路就是考虑从后往前找到第一个降序的位置交换 ai与后面的小于ai的最大值，注意这里后面的最大值可能相等，那么取第一个值
        public int[] prevPermOpt1(int[] arr) {
            for (int i = arr.length-2; i >=0; i--) {    // 外层循环控制找到降序的位置
                if (arr[i]>arr[i+1]){
                    // 这里说明找到了位置
                    int j=i+1;
                    while (j+1<arr.length&&arr[i]>arr[j+1]){
                        j++;
                    }
                    while (arr[j]==arr[j-1]){
                        j--;
                    }
                    swap(arr,i,j);
                    return arr;
                }
            }

            return arr;
        }
        void swap(int[] arr,int i,int j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
    static class Code1054{
        public int[] rearrangeBarcodes(int[] barcodes) {
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < barcodes.length; i++) {
                map.put(barcodes[i],map.getOrDefault(barcodes[i],0)+1);
            }
            PriorityQueue<Pair> queue=new PriorityQueue<>((p1,p2)->p2.count-p1.count);
            for (Map.Entry<Integer,Integer> entry:map.entrySet()){
                queue.offer(new Pair(entry.getKey(),entry.getValue()));
            }
            List<Integer> res=new ArrayList<>();
            while (queue.size()>1){
                final Pair poll1 = queue.poll();
                final Pair poll2 = queue.poll();
                res.add(poll1.label);
                res.add(poll2.label);
                poll1.count=poll1.count-1;
                poll2.count=poll2.count-1;
                if (poll1.count>0){
                    queue.offer(poll1);
                }
                if (poll2.count>0){
                    queue.offer(poll2);
                }
            }
            while (!queue.isEmpty()){
                res.add(queue.poll().label);
            }
            return res.stream().mapToInt(Integer::intValue).toArray();
        }
        class Pair{
            public int label;
            public int count;

            public Pair(int label, int count) {
                this.label = label;
                this.count = count;
            }

            @Override
            public boolean equals(Object o) {
                if (o==null)
                    return false;
                if (this==o)
                    return true;
                if (o instanceof Pair){
                    Pair p= (Pair) o;
                    return p.label==this.label;
                }
                return false;
            }

            @Override
            public int hashCode() {
                int result=17;
                result=result*31+this.label;
                return result;
            }
        }
    }
}