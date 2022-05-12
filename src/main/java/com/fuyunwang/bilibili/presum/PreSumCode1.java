package com.fuyunwang.bilibili.presum;

import java.util.HashMap;
import java.util.HashSet;

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
    class Code1052{
        // 爱生气的书店老板
    }
    class Code1074{

    }
    class Code1094{

    }
    class Code1190{

    }
}
