package com.fuyunwang.bilibili.presum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Title PreSumCode1
 * @Author fyw
 * @Date 2022-05-11 17:15
 * @Description
 */
public class PreSumCode1 {
    class Code303_304{
//        class NumMatrix {
//            int[][] sum;
//            public NumMatrix(int[][] matrix) {
//                if (matrix.length!=0&&matrix[0].length!=0){
//                    sum=new int[matrix.length+1][matrix[0].length+1];
//                    for (int i = 1; i <= sum.length; i++) {
//                        for (int j = 1; j <= sum[0].length; j++) {
//                            matrix[i][j]=sum[i-1][j]+sum[i][j-1]+matrix[i-1][j-1]-sum[i-1][j-1];
//                        }
//                    }
//                }
//            }
//            public int sumRegion(int row1, int col1, int row2, int col2) {
//                row1++;
//                col1++;
//                row2++;
//                col2++;
//                return sum[row2][row2]-sum[row2][col1-1]-sum[row1-1][col2]+sum[row1-1][col1-1];
//            }
//        }
    }
    class Code523{  // 560、523、862、930
        public boolean checkSubarraySum(int[] nums, int k) {
            if (k==0){
                for (int i = 0; i < nums.length; i++) {
                    if (i>0&&nums[i]==0&&nums[i-1]==0)
                        return true;
                }
                return false;
            }
            int[] sum=new int[nums.length+1];
            for (int i = 1; i <= nums.length; i++) {
                sum[i]=sum[i-1]+nums[i-1];
            }
            HashSet<Integer> set=new HashSet<>();
            for (int i = 2; i <= nums.length; i++) {
                set.add(sum[i-2]%k);
                if (set.contains(sum[i]%k))
                    return true;
            }
            return false;
        }
    }
    class Code525{
        public int findMaxLength(int[] nums) {
            int n=nums.length;
            Map<Integer,Integer> map=new HashMap<>();   // 存储当前前缀和第一次出现的位置，也就是最小下标，注意0一定要预存
            map.put(0,0);
            int res=0;
            for (int i = 1,one=0,zero=0; i <= nums.length; i++) {
                if (nums[i-1]==1)
                    one++;
                if (nums[i-1]==0)
                    zero++;
                if (map.containsKey(one-zero)){
                    res=Math.max(res,i-map.get(one-zero));
                }else{
                    map.put(one-zero,i);
                }
            }
            return res;
        }
    }
    class Code560{
        public int subarraySum(int[] nums, int k) {
            int n=nums.length;
            int[] sum=new int[n+1];
            for (int i = 1; i <= n; i++) {
                sum[i]=sum[i-1]+nums[i-1];
            }
            HashMap<Integer,Integer> map=new HashMap<>();   // 记录前缀和出现的次数
            map.put(0,1);       // 0出现了1次
            int res=0;
            for (int i = 1; i <= n; i++) {
                res+=map.getOrDefault(sum[i]-k,0);
                map.put(sum[i],map.getOrDefault(sum[i],0)+1);
            }
            return res;
        }
    }
    class Code724{
        public int pivotIndex(int[] nums) {
            int n=nums.length;
            // 首先记录总和
            int sum=0;
            for (int i = 0; i < n; i++) {
                sum+=nums[i];
            }
            // 然后找到中心位置索引
            for (int i = 0,preSum=0; i <nums.length ; i++) {
                if (sum-preSum-nums[i]==preSum)
                    return i;
                preSum+=nums[i];
            }
            return -1;
        }
    }
    class Code862{

    }

    class Code930{  // 560题的简化
        public int numSubarraysWithSum(int[] nums, int goal) {
            int res=0;
            HashMap<Integer,Integer> map=new HashMap<>();// 存储前缀和以及次数
            map.put(0,1);
            int preSum=0;
            for (int i = 0; i < nums.length; i++) {
                preSum+=nums[i];
                res+=map.getOrDefault(preSum-goal,0);
                map.put(preSum,map.getOrDefault(preSum,0)+1);
            }
            return res;
        }
    }
    class Code974{
        public int subarraysDivByK(int[] nums, int k) {     // Si与Sj在mod k的前提下是同余的
            int[] sum=new int[nums.length+1];
            for (int i = 1; i <= nums.length; i++) {
                sum[i]=sum[i-1]+nums[i-1];
            }
            int res=0;
            Map<Integer,Integer> map=new HashMap<>();
            map.put(0,1);
            for (int i = 1; i <= nums.length; i++) {
                res+=map.getOrDefault((sum[i]%k+k)%k,0);
                map.put((sum[i]%k+k)%k,map.getOrDefault((sum[i]%k+k)%k,0)+1);
            }
            return res;
        }
    }


    class Code209{ // 209 926 1004 1052
        public int minSubArrayLen(int target, int[] nums) {// 子数组问题考虑560题目
            int sum=0;
            int res=Integer.MAX_VALUE;
            for (int i = 0,j=0; i < nums.length; i++) {
                sum+=nums[i];
                while (sum-nums[j]>=target)
                    sum-=nums[j++];
                if (sum>=target)
                    res=Math.min(res,i-j+1);

            }
            return res==Integer.MAX_VALUE?0:res;
        }
    }
    class Code1004{
        public int longestOnes(int[] nums, int k) {
            int res=0;
            for (int i = 0,j=0,count=0; i < nums.length; i++) { // i和j其实就是左右指针
                if (nums[i]==0)
                    count++;
                while (count>k){
                    if (nums[j]==0)
                        count--;
                    j++;
                }
                res=Math.max(res,i-j+1);
            }
            return res;
        }
    }
    class Code1052{
        // 爱生气的书店老板、类似1004 有双指针的思想
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int sum=0;
            for (int i = 0; i < customers.length; i++) {
                if (grumpy[i]==0){
                    sum+=customers[i];
                    customers[i]=0;
                }
            }
            int res=sum;
            for (int i = 0; i < customers.length; i++) {
                if (i<minutes){
                    sum+=customers[i];
                }else{
                    sum=sum+customers[i]-customers[i-minutes];
                }
                res=Math.max(res,sum);
            }
            return res;
        }
    }
    class Code926{  // 又有点类似525、经典前缀和
        // 本质上将一个序列变成前面一堆0后面一堆1
        // 需要统计每个分界点前1的个数和分界点后0的个数即可
        // 设索引i处于最后一个0的位置那么 si (n-i)-(sn-si) 就分别为所求
        public int minFlipsMonoIncr(String s) {
            int n=s.length();
            int[] sum=new int[n+1];
            for (int i = 1; i <= n; i++) {
                sum[i]=sum[i-1]+s.charAt(i-1)-'0';
            }
            // 索引的枚举是以0的个数来的，所以边界条件应该是全变成1的情况
            int res=n-sum[n];
            for (int i = 1; i <= n; i++) {
                res=Math.min(res,2*sum[i]+(n-i)-(sum[n]));
            }
            return res;
        }
    }
    class Code995{

    }

    class Code1074{
        // 二维数组前缀和+85题最大矩形的思想
    }
    // 统计类型题目用差分
    class Code1094{
        public boolean carPooling(int[][] trips, int capacity) {
            int[] d=new int[trips.length];
            for (int i = 0; i < trips.length; i++) {
                d[trips[i][0]]+=trips[i][2];
                d[trips[i][1]]-=trips[i][2];
            }
            int preSum=0;
            for (int i = 0; i < d.length; i++) {
                preSum+=d[i];
                if (preSum>capacity){
                    return false;
                }
            }
            return true;
        }
    }
    class Code1109{
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] d=new int[n];
            for (int i = 0; i < bookings.length; i++) {
                d[bookings[i][0]-1]+=bookings[i][2];
                if (bookings[i][1]<n){
                    d[bookings[i][1]]-=bookings[i][2];
                }
            }
            for (int i = 1; i < n; i++) {
                d[i]+=d[i-1];
            }
            return d;
        }
    }
    class Code1124{
        // 也是一个返回最大长度的问题
        
    }
}