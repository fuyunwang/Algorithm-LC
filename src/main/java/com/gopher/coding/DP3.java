package com.gopher.coding;

import java.util.*;
import java.io.*;

/**
 * @Title DP3
 * @Author fyw
 * @Date 2022-02-21 18:53
 * @Description 计数类DP 数位统计DP 状态压缩DP 树形DP 记忆化搜索
 */
public class DP3 {
    static class Code1{
        // 整数划分
    }

    static class Code2{
        // 计数问题，数位统计DP
        /**
         * 给定两个整数 a 和 b，求 a 和 b 之间的所有数字中 0∼9 的出现次数。
         *
         * 例如，a=1024，b=1032，则 a 和 b 之间共有 9 个数如下：
         *
         * 1024 1025 1026 1027 1028 1029 1030 1031 1032
         *
         * 其中 0 出现 10 次，1 出现 10 次，2 出现 7 次，3 出现 3 次等等…
         */

        static int get(List<Integer> list, int l, int r){
            int res = 0;
            for(int i=l; i>=r; i--){
                res = res * 10 + list.get(i);
            }
            return res;
        }

        static int power10(int x){
            int res = 1;
            while(x!=0){
                res *= 10;
                x--;
            }
            return res;
        }

        //统计从1-n，x出现的次数
        static int count(int n, int x){
            if(n==0) return 0; //如果n为0，那直接返回0就行了
            List<Integer> l = new ArrayList<>();

            //将n的每一位加入到l中
            while(n!=0){
                l.add(n % 10);
                n /= 10;
            }
            int len = l.size();

            //对于0,不需要枚举最高位
            int res = 0;
            for(int i=len-1-(x==0?1:0); i>=0; i--){
                if(i < len-1){
                    res += get(l, len-1, i+1) * power10(i);
                    if(x == 0) res -= power10(i);
                }

                if(l.get(i) > x) res += power10(i);
                else if(l.get(i) == x) res += get(l, i-1, 0) + 1;
            }

            return res;
        }

        public static void main(String[] args) throws IOException{
            // 输入以空格分开的两个数
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String[] arr = in.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            while(a!=0 || b!=0){
                if(a > b){
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
                //枚举每一个数字，输出
                for(int i=0; i<=9; i++){
                    System.out.print(count(b, i)-count(a-1, i)+" ");
                }
                System.out.println();

                String[] cur = in.readLine().split(" ");
                a = Integer.parseInt(cur[0]);
                b = Integer.parseInt(cur[1]);
            }
        }

    }
}
