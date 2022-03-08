package com.gopher.leetcode.types.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title NnumberSum
 * @Author fyw
 * @Date 2022-03-08 9:13
 * @Description N数之和
 */
public class NnumberSum {

    static class Code15{
        // 三数之和
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result=new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i>0&&nums[i]==nums[i-1])continue;
                for (int j=i+1,k=nums.length-1;j<k;j++){
                    if (j>i+1&&nums[j]==nums[j-1])
                        continue;
                    while (j<k-1&&nums[i]+nums[j]+nums[k-1]>=0)
                        k--;
                    if (nums[i]+nums[j]+nums[k]==0){
                        result.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    }
                }
            }
            return result;
        }
    }

    static class Code16{
        // 最接近的三数之和
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int result=0x3f3f3f3f;
            for (int i = 0; i < nums.length; i++) {
                if (i>0&&nums[i]==nums[i-1])
                    continue;
                for (int j=i+1,k=nums.length-1;j<k;){
                    int sum = nums[i]+nums[j]+nums[k];
                    result = Math.abs(sum-target)<Math.abs(result-target)?sum:result;
                    if (sum>target){
                        k--;
                    }else if (target>sum){
                        j++;
                    }else{
                        return target;
                    }
                }
            }
            return result;
        }
    }

    static class Code18{
        // 四数之和
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result=new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    for (int k = j + 1, u = nums.length - 1; k < u; k++) {
                        if (k > j + 1 && nums[k] == nums[k - 1]) {
                            continue;
                        }
                        while (k < u - 1 && nums[i] + nums[j] + nums[k] + nums[u - 1] >= target) u--;
                        if (nums[i] + nums[j] + nums[k] + nums[u]==target){
                            result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[u])));
                        }
                    }
                }
            }
            return result;
        }
    }

    static class Code923{
        // 三数之和的多种可能
        int MOD = 1000000007;
        int cnt[] =  new int[310];
        // 定义求组合数
        long C (int a, int b){
            long res = 1;
            for (int i = a, j = 1; j <= b; i--, j++){
                res = res*i/j;
            }
            return res%MOD;
        }
        int calc(int a, int b, int c){
            if (a == b && b == c) return (int)C(cnt[a], 3);//三数相同
            if (a == b) return (int)(C(cnt[a], 2)*cnt[c]%MOD);
            if (b == c) return (int)(cnt[a]*C(cnt[b], 2)%MOD);
            return (int)(cnt[a]*cnt[b]*cnt[c]%MOD);
        }
        public int threeSumMulti(int[] arr, int target) {
            for (int x:arr) cnt[x]++;
            int res = 0;
            for (int i = 0; i<= target; i++){
                for (int j = i; j <= target - i - j; j++){
                    res = (res + calc(i, j, target - i - j))%MOD;
                }
            }
            return res;
        }
    }
}
