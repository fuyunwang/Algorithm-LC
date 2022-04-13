package com.gopher.leetcode.types.dp;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title Template2
 * @Author fyw
 * @Date 2022-03-03 16:45
 * @Description 序列
 */
public class Template2 {
    static class Code931{
        // 下降路径最小和，类似数字三角形，路径类DP坐标不错位、一一对应
        public int minFallingPathSum(int[][] matrix) {
            // 典型dp求路径类问题，类似于数字三角形。f(i,j)表示到a(i,j)点的最小路径和
            // f(i,j) = min(f(i-1,j -1), f(i-1,j),f(i -1,j+1)) + a[i,j]
            // 要注意在边界情况，初始值第0行原样赋值, 这里有个技巧，通过k来枚举三种情况，避免了多次判断
            int n = matrix.length;
            int m = matrix[0].length;
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int i = 0; i < m; i++) dp[0][i] = matrix[0][i];

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = Math.max(0, j - 1); k <= Math.min(m - 1, j + 1); k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + matrix[i][j]);
                    }
                }
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) res = Math.min(res, dp[n - 1][i]);
            return res;
        }
    }

    static class Code960{
        // f[i]表示只看前i列（包含第i列）所有合法方案的集合，属性是最少删除列
    }

    // 顺序不同的序列被视作不同的组合。
    static class Code377{
        // 状态表示：定义f[i][j]为组合长度为i，凑成总和为j的方案数是多少。由于对组合方案的长度没有限制，因此我们最终答案为所有的f[x][target]的总和。
        // 状态计算：那么对任意的f[len][target]而言，组合中的最后一个数字可以选择nums中的任意数值。 f[len][target]=f[len-1][target-nums[0]]+f[len-1][target-nums[1]]+...
        public int combinationSum4(int[] nums, int target) {
            // 因为 nums[i] 最小值为 1，因此构成答案的最大长度为 target
            int len=target;
            int[][] f=new int[len+10][target+10];
            f[0][0]=1;
            int res=0;
            for (int i = 1; i <= len; i++) {
                for (int j = 0; j <= target; j++) {
                    for (int k = 0; k < nums.length; k++) {
                        // 做选择，target的值需要存储下nums[k]才可，完全背包
                        if (j>=nums[k]){
                            f[i][j]=f[i][j]+f[i-1][j-nums[k]];
                        }
                    }
                }
                res+=f[i][target];
            }
            return res;
        }
    }

    static class Code1014{

    }

    static class Code1035{
        // 不相交的线，最长公共子序列
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int m=nums1.length;
            int n=nums2.length;
            int[][] f=new int[m+1][n+1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    f[i][j]=Math.max(f[i][j-1],f[i-1][j]);
                    if (nums1[i-1]==nums2[j-1]){
                        f[i][j]=Math.max(f[i][j],f[i-1][j-1]+1);
                    }
                }
            }
            return f[m][n];
        }
    }

    static class Code1092{
        public String shortestCommonSupersequence(String str1, String str2) {
            /**
             * f[i][j]表示字符串1的前i位进行扩充直到包含字符串2的前j位的最小方案数
             *
             * 集合划分依据就是当前最后一个字符是否相等
             */
            int n=str1.length();
            int m=str2.length();
            // 我这里没有将str1和str2前面加“ ”补齐，所以后续索引对应应该注意
            int[][] f=new int[n+1][m+1];
            for (int i = 0; i <= n; i++) {
                f[i][0]=0;
            }
            for (int i = 1; i <= m; i++) {
                f[0][i]=i;
            }

            // dp 的核心思想就是前面的都已经匹配好了，只需要考虑当前这位。
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (str1.charAt(i-1)==str2.charAt(j-1)){    // 如果当前字符相等那么说明不需要扩充，结果仍然是去掉当前这位的结果
                        f[i][j]=f[i-1][j-1];
                    }else{
                        // 考虑既要包含a又要包含b的情况。可以保证a已经包含b是f[i-1][j]，可以保证a还差一个字符才包含b的情况f[i][j-1]+1。以上两种情况都一定保证是满足要求所以取最小的可能方案
                        f[i][j]=Math.min(f[i][j-1]+1,f[i-1][j]);
                    }
                }
            }

            StringBuilder sb=new StringBuilder();
            for (int i = n,j=m; i>0||j>0;) {
                if (i==0){
                    sb.append(str2.charAt(--j));
                }else if (j==0){
                    sb.append(str1.charAt(--i));
                }else{
                    if (str1.charAt(i-1)==str2.charAt(j-1)){
                        sb.append(str1.charAt(--i));
                        --j;
                    }else{
                        if (f[i][j]==f[i][j-1]+1){
                            sb.append(str2.charAt(--j));
                        }else{
                            sb.append(str1.charAt(--i));
                        }
                    }
                }
            }
            return sb.reverse().toString();
        }
    }

    static class Code730{
        // 统计不同的回文子序列
        /**
         * f[i,j]表示 【i，j】中的不同回文子序列的数量(包含空序列)
         *
         * 单独一个字母也是一种子序列
         * dp问题我们直接考虑能生成正确答案的分类情况，这里4种字符所以划分为4类
         */
        public int countPalindromicSubsequences(String s) {
            int mod = (int)1e9 + 7;
            int n = s.length();
            int[][] f = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    f[i][j] = 1;
                }
                f[i][i] = 2;
            }
            for (int len = 2; len <= n; ++len) {
                Deque<Integer>[] q = new Deque[4];
                for (int i = 0; i < 4; ++i) {
                    q[i] = new LinkedList<>();
                }
                for (int i = 0; i < len - 1; i++) {
                    q[s.charAt(i) - 'a'].add(i);
                }
                for (int i = 0; i + len <= n; ++i) {
                    int j = i + len - 1;
                    int p = s.charAt(j) - 'a';
                    q[p].offerLast(j);

                    for (int k = 0; k < 4; ++k) {

                        if (q[k].size() > 0) {
                            f[i][j]++;
                            if (q[k].size() > 1) {
                                int l = q[k].peekFirst(), r = q[k].peekLast();
                                f[i][j] += f[l + 1][r - 1];
                                f[i][j] %= mod;
                            }
                        }
                    }
                    q[s.charAt(i) - 'a'].pollFirst();
                }
            }
            return (f[0][n - 1] + mod - 1) % mod;
        }
    }

    static class Code740{

    }

    static class Code741{
        // 类似题目，方格取数、传纸条

    }

    static class Code1027{
        // 最长等差数列
        // f[i,j]表示所有以i结尾且公差为j的子序列的集合，属性最大值 | 枚举第二个数
        public int longestArithSeqLength(int[] nums) {
            int n = nums.length;
            int maxLen = 1; // at least has 1 element
            // dp[i][diff] means the length of Arithmetic Subsequence which difference is diff and last element is nums[i]
            int offSet = 500;
            int[][] dp = new int[n][offSet * 2 + 10];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int diff = nums[i] - nums[j] + offSet;
                    if (dp[j][diff] == 0) {
                        dp[i][diff] = 2;
                    } else {
                        dp[i][diff] = 1 + dp[j][diff];
                    }
                    maxLen = Math.max(maxLen, dp[i][diff]);
                }
            }

            return maxLen;
        }
    }

    static class Code983{
        // 递推
        public int mincostTickets(int[] days, int[] costs) {
            // f[i] 表示玩完前i天，并且最后一张票以i结尾的最小花费
            int n = days.length;
            int[] f = new int[n + 1];
            for (int i= 1, a = 0, b= 0, c = 0; i <= n; i++){
                while (days[i - 1] - days[a] >= 1) a++;
                while (days[i - 1] - days[b] >= 7) b++;
                while (days[i - 1] - days[c] >= 30) c++;
                f[i] = Math.min(f[a] + costs[0], Math.min(f[b] + costs[1], f[c] + costs[2]));
            }
            return f[n];
        }
    }

    static class Code978{
        // 递推
        public int maxTurbulenceSize(int[] arr) {
            int res = 1;
            for (int i = 1, up = 1, down = 1; i < arr.length; i++){
                if (arr[i] > arr[i - 1]){
                    up = down + 1;
                    down = 1;
                } else if(arr[i] < arr[i - 1]){
                    down = up + 1;
                    up = 1;
                } else {
                    down = 1;
                    up = 1;
                }
                res = Math.max(res, Math.max(up, down));
            }
            return res;
        }
    }
}
