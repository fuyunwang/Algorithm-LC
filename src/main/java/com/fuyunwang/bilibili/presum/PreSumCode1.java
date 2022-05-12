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

    }
    class Code523{  // 560、523、862
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
    class Code926{

    }
    class Code930{

    }
    class Code974{

    }
    class Code995{

    }

    class Code209{
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

    class Code1074{
        // 二维数组前缀和+85题最大矩形的思想
    }
    class Code1094{

    }
    class Code1109{

    }
    class Code1124{
        // 也是一个返回最大长度的问题

    }
}
