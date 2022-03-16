package com.gopher.ending.backtrack;

import java.util.*;
import java.io.*;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022/3/12 19:19
 * @Description:
 */
public class Template1 {
    static class CodeWing1{
        // 全排列,Code
        List<List<Integer>> ans=new LinkedList<>();
        boolean[] visited;
        int n;
        public List<List<Integer>> permuteUnique(int[] nums) {
            // 必须排序放到一起
            Arrays.sort(nums);
            n=nums.length;
            visited=new boolean[n];
            backtrack(nums,new LinkedList<>());
            return ans;
        }
        void backtrack(int[] nums,LinkedList<Integer> path){
            if (path.size()==n){
                ans.add(new LinkedList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]){
                    if (i>0&&nums[i-1]==nums[i]&&!visited[i-1])
                        continue;
                    visited[i]=true;
                    path.addLast(nums[i]);
                    backtrack(nums,path);
                    path.removeLast();
                    visited[i]=false;
                }
            }
        }
    }
    static class CodeWing2{
        // n皇后，列控制终止条件，枚举每一行
        static int N=20;
        static char[][] g=new char[N][N];
        // 存储是否访问过的标记
        static boolean[] col=new boolean[N];
        static boolean[] udg=new boolean[N];
        static boolean[] dg=new boolean[N];
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j]='.';
                }
            }
            dfs(0,n);
        }
        static void dfs(int y,int n){
            if (y==n){
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(g[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
                return;
            }
            for (int x = 0; x < n; x++) {   // 在当前列的每一行进行皇后放置
                if(!col[x]&&!udg[x+y]&&!dg[y-x+n]){
                    col[x]=true;
                    udg[x+y]=true;
                    dg[y-x+n]=true;
                    g[x][y]='Q';
                    dfs(y+1,n);
                    g[x][y]='.';
                    col[x]=false;
                    udg[x+y]=false;
                    dg[y-x+n]=false;
                }
            }
        }

    }


    static class Code332{
        // 重新安排路程
    }
}
