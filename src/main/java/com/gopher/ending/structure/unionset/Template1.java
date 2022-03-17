package com.gopher.ending.structure.unionset;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022/3/12 20:27
 * @Description:
 * 并查集用于判断环，如果两个点在连线之前已经处于同一个连通块那么可以成环
 */
public class Template1 {
    static class CodeWing1{
        // 格子游戏，计算第几行结束游戏，也就是第几行两个点在一个连通块
        static int N=201*201+10;
        static int n,m;
        static int[] p=new int[N];
        static int find(int x){
            if (p[x]!=x)
                p[x]=find(p[x]);
            return p[x];
        }
        static int get(int x,int y){
            return x*n+y;       // 返回二维索引对一维索引的映射
        }
        public static void main(String[] args) throws IOException {
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String[] str1=reader.readLine().trim().split(" ");
            n=Integer.parseInt(str1[0]);
            m=Integer.parseInt(str1[1]);
            for (int i = 0; i < n*n; i++) { // 编号索引进行映射
                p[i]=i;
            }
            int res=0;
            for (int i = 1; i <= m; i++) { // 读入M个操作
                String[] str2=reader.readLine().trim().split(" ");
                int x=Integer.parseInt(str2[0])-1;// 注意编号到索引的对应
                int y=Integer.parseInt(str2[1])-1;
                String d=str2[2];
                int a=get(x,y);
                int b;
                if (d.equals("D"))
                    b=get(x+1,y);
                else
                    b=get(x,y+1);

                int pa=find(a);
                int pb=find(b);

                if (pa==pb){
                    res=i;
                    break;
                }
                p[pa]=pb;
            }
            if (res==0)
                System.out.println("draw");
            else
                System.out.println(res);
        }
    }
    static class CodeWing2{
        // 搭配购买

        static int N = 10010;
        static int n,m,vol;
        static int[] v = new int[N];
        static int[] w = new int[N];
        static int[] p = new int[N];
        static int[] f = new int[N];
        static int find(int x)
        {
            if(p[x] != x) p[x] = find(p[x]);
            return p[x];
        }
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] s1 = br.readLine().split(" ");
            n = Integer.parseInt(s1[0]);
            m = Integer.parseInt(s1[1]);
            vol = Integer.parseInt(s1[2]);
            for(int i = 1;i <= n;i ++) p[i] = i;
            for(int i = 1;i <= n;i ++) {
                String[] s2 = br.readLine().split(" ");
                v[i] = Integer.parseInt(s2[0]);
                w[i] = Integer.parseInt(s2[1]);
            }
            while(m -- > 0) {
                String[] s3 = br.readLine().split(" ");
                int a = Integer.parseInt(s3[0]);
                int b = Integer.parseInt(s3[1]);
                int pa = find(a);
                int pb = find(b);
                if(pa != pb) {
                    v[pb] += v[pa];
                    w[pb] += w[pa];
                    p[pa] = pb;
                }
            }
            //01 背包
            for(int i = 1;i <= n;i ++)
                if(p[i] == i)
                    for(int j = vol;j >= v[i];j --)
                        f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            System.out.println(f[vol]);
        }
    }

    static class Code765{
        int[] p;

        public int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        public int minSwapsCouples(int[] row) {
            int n = row.length / 2;
            p = new int[n];
            for (int i = 1; i < n; i++) {
                p[i] = i;
            }
            int cnt = n;
            for (int i = 0; i < row.length; i += 2) {
                int a = row[i];
                int b = row[i + 1];
                int pa = find(a / 2);
                int pb = find(b / 2);
                if (pa != pb) {
                    p[pa] = pb;
                    cnt--;
                }
            }
            return n - cnt;
        }
    }
    static class Code721{
        // 账户合并
    }
}
