package com.gopher.hardcoding.structure;

import java.util.Scanner;

/**
 * @Title UnionFindSet
 * @Author fyw
 * @Date 2022-02-26 16:25
 * @Description 并查集
 */
public class UnionFindSet {
    static class Code1{
        static int[] p,size;
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            p = new int[n + 10];
            size=new int[n+10];
            // 初始化
            for (int i = 1; i <= n; i ++) {
                p[i] = i; // 让每个元素的父是自己
                size[i]=1;//记录当前集合中的元素个数
            }
            int a = in.nextInt();
            int b = in.nextInt();
            size[find(b)] += size[find(a)];
            p[find(a)] = find(b);       // 合并操作包含了查询操作和路径压缩操作
            System.out.println(size[find(a)]);
        }
        private static int find(int x) {
            if (x != p[x]) { // p不是自己说明还没到根节点
                p[x] = find(p[x]);      // 路径压缩
            }
            return p[x]; // 返回p
        }
    }
}
