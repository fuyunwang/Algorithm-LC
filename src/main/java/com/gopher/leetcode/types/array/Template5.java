package com.gopher.leetcode.types.array;

import java.util.*;

/**
 * @Title Template5
 * @Author fyw
 * @Date 2022-03-05 22:22
 * @Description 前缀和
 */
public class Template5 {

    static class Code930{
        // 和相同的二元子数组
        public int numSubarraysWithSum(int[] nums, int goal) {
            int[] sum=new int[nums.length+1];
            for (int i = 1; i <= nums.length; i++) {
                sum[i]=sum[i-1]+nums[i-1];
            }
            Map<Integer,Integer> map=new HashMap<>();
            map.put(0,1);
            int res=0;
            for (int i = 1,s=0; i <= nums.length; i++) {
                s+=nums[i-1];
                res+=map.getOrDefault(s-goal,0);
                map.put(s,map.getOrDefault(s,0)+1);
            }
            return res;
        }
    }

    static class Code926{
        public int minFlipsMonoIncr(String str) {
            int n = str.length();
            int [] s = new int[n + 1];
            for (int i = 1; i <= n; i++){
                s[i] = s[i - 1] + str.charAt(i - 1) - '0';
            }
            int res = n - s[n];
            for (int i = 1; i <= n; i++){
                //前面1的个数+后面0的个数  即需要修改的次数 遍历取个最小值
                res = Math.min(res, s[i] + n - i - (s[n] - s[i]));
            }
            return res;
        }
    }

    static class Code995{

    }

    static class Code1074{
        // 二维数组前缀和
        /**
         * 思想
         * 1. 矩阵问题可以使用二维循环固定一行来枚举后续行，从而将二维问题转换为一维问题
         * 2. 区间和-> 利用前缀和->目标值配合前缀和使用map来优化
         *
         */
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int m=matrix.length;
            int n=matrix[0].length;
            // 预处理列前缀和
            int[][] preSum=new int[m+1][n+1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    preSum[i][j]=preSum[i-1][j]+matrix[i-1][j-1];
                }
            }
            int res=0;
            for (int i = 1; i <= m; i++) {
                for (int j = i; j <= m; j++) {
                    Map<Integer,Integer> temp=new HashMap<>();
                    temp.put(0,1);
                    int sum=0;
                    // 固定好行段之后开始枚举列区间
                    for (int k = 1; k <= n; k++) {
                        sum+=preSum[j][k]-preSum[i-1][k];       // 横方向的前缀和
                        res+=temp.getOrDefault(sum-target,0);
                        temp.put(sum,temp.getOrDefault(sum,0)+1);
                    }
                }
            }
            return res;
        }
    }
    static class Code1031{
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            return Math.max(maxWork(nums, firstLen, secondLen), maxWork(nums, secondLen, firstLen));
        }

        private int maxWork(int[] nums, int a, int b) {
            int n=nums.length;
            int[] sums = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }

            int res=0;
            for (int i = a + b, maxa = 0; i <= n; i++) {
                maxa = Math.max(maxa, sums[i - b] - sums[i - b - a]);
                res = Math.max(res, sums[i] - sums[i - b] + maxa);
            }
            return res;
        }
    }
    static class Code1052{
        // 爱生气的书店老板
        // 满意人数=原本满意人数+新增满意人数
        // 滑动窗口连续分钟内生气时间的最大值
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int n=customers.length;
            int sum=0;
            for (int i = 0; i < n; i++) {
                if (grumpy[i]==0){
                    sum+=customers[i];  // 不生气的肯定算在结果之内，所以必须要加，为了防止后面重复加采用擦除策略
                    customers[i]=0;
                }
            }
            // 从头采用滑动窗口的方式累计最大值
            int res=sum;
            for (int i = 0; i < n; i++) {
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

    static class Code2100{
        //  适合打劫银行的日子
        /**
         * 根据其中的两个要求：
         *  第 i 天前连续 time 天警卫数目都是非递增的、第 i 天后连续 time 天警卫数目都是非递减的。
         * 1. 说明合理的结果范围区间的起始索引是time，终止索引n-time。其中time可以取到,n-time取不到
         * 2. 枚举以上区间，然后对于区间的每一个值枚举其左侧time范围和右侧time范围，保证左侧time不严格升序，右侧time不严格降序
         *
         * 本题是山脉数组的逆向，山谷数组
         */
        public List<Integer> goodDaysToRobBank(int[] security, int time) {
            int n=security.length;
            int[] right=new int[n+1];   // 始终记录数组中当前索引下左侧小于等于当前数的个数
            int[] left=new int[n+1];    // 始终记录数组中当前索引下右侧大于等于当前数的个数
            for (int i = 1,j=0,k=0; i < security.length; i++) {
                if (security[i]<security[i-1]){
                    j++;
                }else if (security[i]>security[i-1]){
                    k++;
                }else{
                    j++;
                    k++;
                }
                right[i]=k;
                left[i]=j;
            }
            List<Integer> res=new ArrayList<>();
            for (int i = time; i < n-time; i++) {
                if (left[i]-left[i-time]==time&&right[i+time]-right[i]==time){
                    res.add(i);
                }
            }
            return res;
        }
    }

    static class Code2017{

    }
    static class Code845{

    }

    static class Code2055{
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int[] sum=new int[s.length()+1];
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '|') list.add(i);
                sum[i + 1] = sum[i] + (s.charAt(i) == '*' ? 1 : 0);
            }
            int[] res=new int[queries.length];
            if (list.size() == 0) return res;
            for (int i = 0; i < queries.length; i++) {
                int a = queries[i][0], b = queries[i][1];
                int c = -1, d = -1;
                // 找到 a 右边最近的蜡烛
                int l = 0, r = list.size() - 1;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (list.get(mid) >= a) r = mid;
                    else l = mid + 1;
                }
                if (list.get(r) >= a) c = list.get(r);
                else continue;
                // 找到 b 左边最近的蜡烛
                l = 0; r = list.size() - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (list.get(mid) <= b) l = mid;
                    else r = mid - 1;
                }
                if (list.get(r) <= b) d = list.get(r);
                else continue;
                if (c <= d) res[i] = sum[d + 1] - sum[c];
            }

            return res;
        }
    }
    static class Code1012{
        public boolean canThreePartsEqualSum(int[] arr) {
            int n = arr.length ;
            int [] sum = new int [n + 1] ;
            for (int i = 1; i <= n ; ++i) {
                sum[i] = sum[i - 1] + arr[i - 1] ;
            }
            if (sum[n] % 3 != 0) return false ;
            int avg = sum[n] / 3 ;
            int i = 1 ;
            while (i <= n && sum[i] != avg) i++ ;
            int j = n - 1 ;
            while (i + 1 < j && sum[n] - sum[j] != avg) j-- ;
            if (j > i && sum[j] - sum[i] == avg) return true ;
            return false ;


        }
    }
}
