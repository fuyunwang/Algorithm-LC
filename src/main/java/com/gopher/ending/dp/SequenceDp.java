package com.gopher.ending.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Title SequenceDp
 * @Author fyw
 * @Date 2022-03-12 12:42
 * @Description
 */
public class SequenceDp {
    static class CodeWing1{
        // 最长上升子序列
        /**
         * f[i]表示所有以第i个数结尾的上升子序列长度的最大值
         * 状态计算分别以没有倒数第二个数、倒数第二个数的位置是1、是2、。。。 分类计算
         */
        static class Code1{
            static int N=1010;
            static int[] a=new int[N];
            static int[] f=new int[N];
            public static void main(String[] args) {
                Scanner scanner=new Scanner(System.in);
                int n=scanner.nextInt();
                for (int i = 1; i <= n; i++) {
                    a[i]=scanner.nextInt(); // 初始化原始序列
                }
                // 进行状态转移计算的同时更新答案
                int res=0;
                for (int i = 1; i <= n; i++) {
                    f[i]=1;                         // 只有一个数的时候是1
                    for (int j = 1; j < i; j++) {   // 枚举倒数第二个元素的可能情况
                        if (a[j]<a[i]){
                            f[i]=Math.max(f[i],f[j]+1);
                        }
                    }
                    res=Math.max(res,f[i]);
                }
                System.out.println(res);
            }
        }
        static class Code2{
            // 数据范围大了之后,类似贪心
            /**
             * 使用q[]存储所有不同长度的上升子序列结尾的最小值
             * 进来一个数a[i]时，通过二分在q[]中找到最大的小于ai的数，就能够将ai接到该数的后面，即更新q[r + 1] = a[i]
             */
            static int N=100010;
            static int[] a=new int[N];
            static int[] q=new int[N];
            public static void main(String[] args) {
                Scanner scanner=new Scanner(System.in);
                int n=scanner.nextInt();
                for (int i = 0; i < n; i++) {
                    a[i]=scanner.nextInt();
                }
                int len=0;// 记录最大长度
                for (int i = 0; i < n; i++) {
                    int l=0, r=len;
                    while (l<r){
                        int mid=l+r+1>>1;
                        if (q[mid]<a[i]){
                            // 找到第一个小于a[i]且最大的数
                            l=mid;
                        }else{
                            r=mid-1;
                        }
                    }
                    len=Math.max(len,r+1);  // r是索引，所以长度加1
                    q[r+1]=a[i];
                }
                System.out.println(len);
            }
        }

        static class Code3{ // 最长上升子序列、字典序、牛客NC91
            /**
             * f[i] 记录每一个位置上对应的最长上升子序列的最大长度
             * 使用q[]存储所有不同长度的上升子序列结尾的最小值
             * 本题目的核心在于结果的逆向存储（字典序最小），这里可以证明：
             * 假设 f[x]==f[y]且(x<y)
             * 如果 arr[x]<arr[y]那么y可以接在x之后，就保证f[y]>f[x]与假设矛盾
             * 如果 arr[x]==arr[y]那么取前者和后者都是一样的
             * 如果 arr[x]>arr[y]那么正好满足题意
             * @param arr
             * @return
             */
            public int[] LIS (int[] arr) {
                int n=arr.length;
                int[] f=new int[n+10];
                int[] q=new int[n+10];
                List<Integer> list=new ArrayList<>();

                // 默写求上升子序列模型的代码
                int len=0;
                for (int i = 0; i < n; i++) {
                    int l=0,r=len;
                    while (l<r){
                        int mid=l+r+1>>1;
                        if (q[mid]<arr[i]){
                            l=mid;// 必须找到小于arr[i]的最大的位置之后插入
                        }else{
                            r=mid-1;
                        }
                    }
                    // 状态保持
                    len=Math.max(len,r+1);// 计算当前位置的最长上升子序列长度
                    f[i]=r+1;             // 保存当前位置的最长上升子序列长度
                    q[r+1]=arr[i];        // 当前位置之后插入满足上升条件的最小值
                }

                for (int i = n,t=len; i >=0 ; i--) {
                    if (f[i]==t){
                        list.add(arr[i]);
                        t--;
                    }
                }
                Collections.reverse(list);
                int[] res=new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    res[i]=list.get(i);
                }
                return res;
            }
        }
    }
    static class CodeWing2{
        // 最长公共子序列
        /**
         * f[i,j]表示所有以s的前i个字符和以t的前j个字符组成的公共子序列的长度的最大值
         * 考虑最后一个字符，s[i]和t[j]是否同时包含组成了四种情况
         */
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String s = "　"+scanner.next();
            String t = "　"+scanner.next();
            // 进行状态转移计算
            int[][] f=new int[n+1][m+1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    f[i][j]=Math.max(f[i-1][j],f[i][j-1]);
                    if (s.charAt(i)==t.charAt(j)){
                        f[i][j]=Math.max(f[i][j],f[i-1][j-1]+1);
                    }
                }
            }
            System.out.println(f[n][m]);
        }
    }
    static class CodeWing3{
        // 编辑距离
        static class Code1{
            /**
             * f[i,j]表示将s的前i段变成t的前j段的操作方案的操作次数最小值
             * 考虑s[i]和t[j]
             */
            static int N=1010;
            static int[][] f=new int[N][N];
            public static void main(String[] args) {
                Scanner scanner=new Scanner(System.in);
                int n=scanner.nextInt();
                String a=" "+scanner.next();
                int m=scanner.nextInt();
                String b=" "+scanner.next();

                // 初始化
                for (int i = 1; i <= n; i++) {
                    f[i][0]=i;// 需要全部删除
                }
                for (int i = 1; i <= m; i++) {
                    f[0][i]=i;// 需要依次添加
                }

                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        f[i][j]=Math.min(f[i-1][j]+1,f[i][j-1]+1);//分别表示删除和增加
                        if (a.charAt(i)!=b.charAt(j)){
                            f[i][j]=Math.min(f[i][j],f[i-1][j-1]+1);
                        }else{
                            f[i][j]=Math.min(f[i][j],f[i-1][j-1]);
                        }
                    }
                }
                System.out.println(f[n][m]);
            }
        }
        static class Code2{

        }
    }
    static class CodeWing4{
        // 怪盗基德的滑翔翼，本质上是两侧最长上升子序列之和
        static int N=110;
        static int[] f=new int[N];
        static int[] arr=new int[N];
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int T = scanner.nextInt();
            while (T--!=0){
                int n=scanner.nextInt();
                for (int i = 1; i <= n; i++) {
                    arr[i]=scanner.nextInt();
                }

                // 进行状态转移计算
                int res=1;
                for (int i = 1; i <= n; i++) {
                    f[i]=1;
                    for (int j = 1; j < i; j++) {
                        if (arr[i]>arr[j]){
                            f[i]=Math.max(f[i],f[j]+1);
                        }
                    }
                    res=Math.max(res,f[i]);
                }

                for (int i = n; i >=1 ; i--) {
                    f[i]=1;
                    for (int j = n; j >i ; j--) {
                        if (arr[j]<arr[i]){
                            f[i]=Math.max(f[i],f[j]+1);
                        }
                    }
                    res=Math.max(res,f[i]);
                }
                System.out.println(res);
            }
        }
    }
    static class CodeWing5{
        // 登山，类似CodeWing4，只是两侧求和，上题是两侧取最大值

    }
    static class CodeWing6{
        // 合唱队形，和登山一个题
        static int N=1010;
        static int[] arr=new int[N];
        static int[] f=new int[N];  // 记录峰值左侧上升子序列
        static int[] g=new int[N];  // 记录峰值右侧下降子序列

        public static void main(String[] args) throws IOException {
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            int n=Integer.parseInt(reader.readLine().trim());
            String[] str=reader.readLine().trim().split(" ");
            for (int i = 1; i <= n; i++) {
                arr[i]=Integer.parseInt(str[i-1]);
            }
            // 求解状态转移方程
            for (int i = 1; i <= n; i++) {
                f[i]=1;
                for (int j = 1; j < i; j++) {
                    if (arr[i]>arr[j]){
                        f[i]=Math.max(f[i],f[j] + 1);
                    }
                }
            }
            for (int i = n; i >=1 ; i--) {
                g[i]=1;
                for (int j = n; j > i; j--) {
                    if (arr[i]>arr[j]){
                        g[i]=Math.max(g[i],g[j]+1);
                    }
                }
            }
            int res=1;
            for (int i = 1; i <= n; i++) {
                res=Math.max(res,f[i]+g[i]-1);
            }
            System.out.println(n-res); // 注意题目要求是出列最少
        }
    }

    static class CodeWing7{
        // 友好城市
    }
    static class CodeWing8{
        // 最大上升子序列和
    }
    static class CodeWing9{
        // 拦截导弹
    }
    static class CodeWing10{
        // 导弹防御系统
    }
    static class CodeWing11{
        // 最长公共上升子序列
    }
    static class Code629{
        // f[i,j] 表示所有前1~i个字符中包含j个逆序对的排列数的最大值

    }
    static class Code689{

    }
    static class Code813{
        // 最大平均值和分组
        public double largestSumOfAverages(int[] nums, int m) {
            // 1 线性dp经典题，f(i,j)表示将前i个元素分为j段的最大分数。考虑最后一段的长度可以是1..i - 1，即对应下标k
            // 2 k的范围是[0, i - 1] ,则f(i,j) = max(f(k, j - 1) + (si - sk) / (i - k))
            // 3 后面一段可以用前缀和快速求出
            double[][] dp = new double[nums.length + 1][m + 1];
            for (int i = 0; i <= nums.length; i++) Arrays.fill(dp[i], -1e8); // 注意初始化为负数
            dp[0][0] = 0; // 初始值为0
            int[] sum = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) sum[i] = sum[i - 1] + nums[i - 1];
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= m; j++) {
                    for (int k = 0; k < i; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + (sum[i] - sum[k]) / (double)(i - k));
                    }
                }
            }
            return dp[nums.length][m];
        }
    }
    static class Code712{
        // 两个字符串的最小ASCII删除和、最长公共子序列、最长公共超序列都是一类题目
        public int minimumDeleteSum(String s1, String s2) {
            int n = s1.length() ;
            int m = s2.length();
            int [][] f = new int [n + 1][m + 1] ;
            //当某个串长度为0的话，是不能删除其串的
            for (int i = 1 ; i <= m ; ++i)
                f[0][i] = f[0][i - 1] + (int)s2.charAt(i - 1)  ;

            for (int i= 1; i <= n ; ++i)
                f[i][0] = f[i - 1][0] + (int)s1.charAt(i - 1) ;

            s1=" "+s1; s2=" "+s2;
            for (int i = 1; i <= n ;++i)
                for (int j = 1;  j <= m ; ++j)
                    if (s1.charAt(i) == s2.charAt(j))
                        f[i][j] = f[i - 1][j - 1] ;
                    else{
                        int v1=f[i - 1][j] + (int)(s1.charAt(i));
                        int v2=f[i][j - 1] + (int)(s2.charAt(j));
                        int v3=f[i-1][j-1]+(int)(s1.charAt(i))+(int)(s2.charAt(j));
                        f[i][j]=Math.min(v1,Math.min(v2,v3));
                    }

            return f[n][m];
        }
    }
    static class Code960{
        // 删列造序
        public int minDeletionSize(String[] strs) {
            int n = strs.length, m = strs[0].length();
            int[] f = new int[m];
            int res = m;
            for (int i = 0; i < m; ++i) {
                f[i] = i;
                for (int j = 0; j < i; ++j) {
                    if (check(strs, j, i)) {
                        f[i] = Math.min(f[i], f[j] + i - j - 1);
                    }
                }
                res = Math.min(res, f[i] + m - 1 - i);
            }
            return res;
        }
        private boolean check(String[] strs, int j, int i) {
            int n = strs.length;
            for (int k = 0; k < n; ++k) {
                if (strs[k].charAt(j) > strs[k].charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
