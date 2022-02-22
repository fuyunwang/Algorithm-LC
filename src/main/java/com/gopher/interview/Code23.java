package com.gopher.interview;

import java.util.Scanner;

/**
 * @Title Code23
 * @Author fyw
 * @Date 2022-02-22 10:53
 * @Description 递归实现指数型枚举、排列型枚举（全排列）、组合型枚举
 */
public class Code23 {
    static class Code1{
        static int n;
        static int N=20;
        //static int[] a=new int[N];
        static boolean[] st=new boolean[N];
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            n=sc.nextInt();
            dfs(1);
        }
        public static void dfs(int pos){
            if(pos>n){
                for(int i=1;i<=n;i++){
                    if(!st[i]){
                        System.out.print(i+" ");
                    }
                }
                System.out.println();
                return;
            }
            st[pos]=true;
            dfs(pos+1);
            st[pos]=false;
            dfs(pos+1);
        }
    }

}
