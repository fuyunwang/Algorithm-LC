package com.gopher.coding;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Title Code2816
 * @Author fyw
 * @Date 2022/2/14 21:07
 * @Description:
 */
public class DoublePointer {
    class LeetCode03{
        public int lengthOfLongestSubstring(String s) {
            int n=s.length();
            Map<Character, Integer> map = new HashMap<>();
            int res = 0;
            for(int i = 0, j = 0; i < n;i++) {
                char c=s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                while(map.get(c) > 1) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                    j++;
                }
                res = Math.max(res, i-j+1);
            }
            return res;
        }
    }

    static class SubSequence{
        public static void main(String[] args) {
            // 初始化
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[m];
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();

            }
            for(int i=0;i<m;i++)
            {
                b[i]=sc.nextInt();

            }
            // 进行子序列判断，a是b子序列
            int i=0,j=0;
            while(i<n&&j<m)
            {
                if(a[i]==b[j])
                {
                    i++;
                }
                j++;
            }

            if(i==n) System.out.println("Yes");
            else System.out.println("No");
        }
    }

    static class Code800{
        // 两个有序数组分别取元素的目标和等于target的 数对
        static final int N = (int)1e5 + 10;
        static int[] a = new int[N], b = new int[N];
        static Scanner in = new Scanner(System.in);
        public static void main(String[] args) {
            // 初始化
            int n = in.nextInt(), m = in.nextInt(), x = in.nextInt();
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            for (int i = 0; i < m; i++) b[i] = in.nextInt();

            for (int i = 0, j = m - 1; i < n; i++)
            {
                while (j >= 0 && a[i] + b[j] > x) j--;
                if (j >= 0 && a[i] + b[j] == x) System.out.print(i + " " + j);
            }
        }
    }
}
