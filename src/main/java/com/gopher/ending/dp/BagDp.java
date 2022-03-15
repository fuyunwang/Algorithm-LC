package com.gopher.ending.dp;
import java.io.*;
import java.util.*;
/**
 * @Title BagDp
 * @Author fyw
 * @Date 2022/3/14 19:32
 * @Description:
 */
public class BagDp {
    static class CodeWing1{
        // 0-1背包
        public static void main(String[] args) throws IOException{
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String[] str = reader.readLine().trim().split(" ");
            int n=Integer.parseInt(str[0]);
            int m=Integer.parseInt(str[1]);
            int[][] matrix=new int[n+1][2];// 存放所有的信息，第一维度是体积、第二维度是价值
            for(int i=1;i<=n;i++){
                str=reader.readLine().trim().split(" ");
                matrix[i][0]=Integer.parseInt(str[0]);
                matrix[i][1]=Integer.parseInt(str[1]);
            }

            // 进行状态转移计算
            int[] f=new int[m+1];
            for (int i = 1; i <= n; i++) {
                for (int j=m;j>=matrix[i][0];j--){
                    f[j]=Math.max(f[j],f[j-matrix[i][0]]+matrix[i][1]);
                }
            }
            System.out.println(f[m]);
        }
    }
    static class CodeWing2{
        // 完全背包
        /**
         * f[i,j]表示从前i个物品中选，总体积不超过j的选择方案的价值最大值
         * 考虑第i个物品选0个、1个、2个、。。。的情况
         * @param args
         * @throws IOException
         */
        public static void main(String[] args) throws IOException{
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String[] str = reader.readLine().trim().split(" ");
            int n=Integer.parseInt(str[0]);
            int m=Integer.parseInt(str[1]);
            int[][] matrix=new int[n+1][2];// 存放所有的信息，第一维度是体积、第二维度是价值
            for(int i=1;i<=n;i++){
                str=reader.readLine().trim().split(" ");
                matrix[i][0]=Integer.parseInt(str[0]);
                matrix[i][1]=Integer.parseInt(str[1]);
            }

            // 进行状态转移计算
            int[] f=new int[m+1];
            for (int i = 1; i <= n; i++) {
                for (int j=matrix[i][0];j<=m;j++){
                    f[j]=Math.max(f[j],f[j-matrix[i][0]]+matrix[i][1]);
                }
            }
            System.out.println(f[m]);
        }
    }
}
