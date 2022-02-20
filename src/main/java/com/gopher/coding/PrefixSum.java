package com.gopher.coding;


import java.io.*;
import java.util.Scanner;

/**
 * @Title PrefixSum
 * @Author fyw
 * @Date 2022/2/20 16:47
 * @Description:
 */
public class PrefixSum {
    static class Code1{
        public static void main(String[] args) throws IOException {
            // 初始化
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] str = reader.readLine().split(" ");
            int row = Integer.parseInt(str[0]);
            int col = Integer.parseInt(str[1]);
            int n = Integer.parseInt(str[2]);
            int[][] matrix = new int[row][col];
            for(int i = 0; i < row; i++){
                String[] str1 = reader.readLine().split(" ");
                for(int j = 0; j < col; j++){
                    matrix[i][j] = Integer.parseInt(str1[j]);
                }
            }
            // 计算前缀和
            int[][] sum = new int[row + 1][col + 1];
            for(int i = 1; i < row + 1; i++){
                for(int j = 1; j < col + 1; j++){
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
            for(int i = 0; i < n; i++){
                String[] str2 = reader.readLine().split(" ");
                int row1 = Integer.parseInt(str2[0]);
                int col1 = Integer.parseInt(str2[1]);
                int row2 = Integer.parseInt(str2[2]);
                int col2 = Integer.parseInt(str2[3]);

                System.out.println(sum[row2][col2] - sum[row1 -1][col2] -
                        sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1]);
            }
        }
    }
    // 差分：构造b数组使得b数组的前缀和正好对应a数组，那么b数组称为a数组的差分
    // 比如要让a中的每一个数加k，那么对于bl+c，b(r+1)-c即可
    static class Differential{
        static int  N = 100010;
        public static void main(String[] args) {
            Scanner scanner = new Scanner(new BufferedInputStream(System.in));
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            //a为原数组，b为差分数组
            int[] a = new int[N];
            int[] b = new int[N];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }

            //进行n次插入，初始化差分数组
            for(int i=1;i<=n;i++) {
                insert(b, i, i, a[i]);
            }
            while(m-->0) {
                int l,r,c;
                l = scanner.nextInt();
                r = scanner.nextInt();
                c = scanner.nextInt();
                insert(b, l, r, c);
            }

            //经过一系列插入操作后，现在答案数组应该是b数组的前缀和，让b数组变成b的前缀和。
            //公式 b[i] = b[i-1] + b[i]
            for(int i=1;i<=n;i++)b[i] +=b[i-1];
            for(int i=1;i<=n;i++)System.out.print(b[i]+" ");
            System.out.println();
            scanner.close();
        }

        //插入操作函数
        public static void insert(int[] nums,int l,int r,int c) {
            nums[l]+=c;
            nums[r+1]-=c;
        }

    }

    static class Differential02{
        public static void main(String[] args) {
            // 初始化
            Scanner sc = new Scanner (System.in);
            int n = sc.nextInt() , m = sc.nextInt(), q = sc.nextInt();
            int[][] a = new int[1010][1010];//原数组 同时也是b的前缀和数组
            int[][] b = new int[1010][1010];//a的差分数组
            for(int i = 1;i <= n; i ++) {
                for(int j = 1; j <= m; j ++) {
                    a[i][j] = sc.nextInt();
                }
            }
            //求a的差分数组b b[i][j] =a[i][j] - a[i - 1][j] - a[i][j - 1] + a[i - 1][j - 1];
            for(int i = 1;i <= n; i ++) {
                for(int j = 1; j <= m; j ++) {
                    b[i][j] =a[i][j] - a[i - 1][j] - a[i][j - 1] + a[i - 1][j - 1];
                }
            }
            //对差分数组操作 b[x1][y1] += c; b[x1 -1][y2] -= c;b[x2][y1 -1] -= c; b[x2 - 1][y2 - 1] += c;
            for(int i = 0; i < q; i ++) {
                int x1 = sc.nextInt(),y1 = sc.nextInt(),x2 = sc.nextInt(),y2 = sc.nextInt(),c = sc.nextInt();
                b[x1][y1] += c;
                b[x2 + 1][y1] -= c;
                b[x1][y2 + 1] -= c;
                b[x2 + 1][y2 + 1] += c;
            }
            //再对b数组求一遍前缀和数组 并输出
            for(int i = 1;i <= n; i ++) {
                for(int j = 1; j <= m; j ++) {
                    a[i][j] = b[i][j] + a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1];
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}
