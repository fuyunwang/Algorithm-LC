package com.gopher.leetcode.order.or300;

/**
 * @Title Code307
 * @Author fyw
 * @Date 2022/2/16 20:47
 * @Description:
 * 线段树和树状数组的经典问题
 * lowbit(x) => x&-x 表示取x的二进制表示中最后一位1
 */
public class Code307 {

    class NumArray {

        int tr[];
        int nums[];

        int lowbit(int x){
            return x&(-x);
        }

        void add(int x,int c){
            for(int i=x;i<=nums.length;i+=lowbit(i)) tr[i]+=c;
        }

        int query(int x){
            int res=0;
            for(int i=x;i>0;i-=lowbit(i)) res+=tr[i];
            return res;
        }

        public NumArray(int[] arr) {

            tr=new int[arr.length+1];
            this.nums=arr;

            for(int i=1;i<=arr.length;i++) add(i,arr[i-1]);

        }

        public void update(int i, int val) {
            add(i+1,val-nums[i]);
            nums[i]=val;
        }

        public int sumRange(int i, int j) {
            return query(j+1)-query(i);
        }
    }

}
