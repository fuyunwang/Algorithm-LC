package com.gopher.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Title LinkedList
 * @Author fyw
 * @Date 2022-02-21 20:53
 * @Description 链表
 * 数组模拟
 */
public class LinkedList {
    // e[index]表示节点index值，ne[index]表示节点index的next指针即节点index下一个节点索引。空节点的下标用-1表示。head表示头结点下标
    static class Code1{
        public static int N = 100000;
        public static int[] e = new int[N];
        public static int[] ne = new int[N];
        public static int head = -1;
        public static int idx = 0;
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();

            while (n-- > 0) {
                String str = scan.next();
                if (str.equals("H")) {
                    int x = scan.nextInt();
                    insertHead(x);
                } else if (str.equals("I")) {
                    int k = scan.nextInt();
                    int x = scan.nextInt();
                    insert(k - 1, x);
                } else if (str.equals("D")) {
                    int k = scan.nextInt();
                    if (k == 0)
                        head = ne[head];
                    else
                        delete(k - 1);
                }
            }

            int i = head;
            while (i != -1) {
                System.out.print(e[i] + " ");
                i = ne[i];
            }
        }
        // 将x节点插入到下标为k点后
        public static void insert(int k, int x) {
            e[idx] = x;
            ne[idx] = ne[k];
            ne[k] = idx;
            idx++;
        }
        // 头插法
        public static void insertHead(int x) {
            e[idx] = x;
            ne[idx] = head;
            head = idx++;
        }
        // 将下标是k的点下一个点删除
        public static void delete(int k) {
            ne[k] = ne[ne[k]];
        }
    }

    // 双向链表，头尾指针
    static class Code2{
        static int N=100010;
        static int[] l=new int[N];
        static int[] r=new int[N];
        static int[] e=new int[N];
        static int idx;

        static void init(){
            r[0]=1;
            l[1]=0;
            idx=2;
        }
        // 在索引为k的节点后插入值为x的节点
        static void add(int k,int x){
            e[idx]=x;
            l[idx]=k;
            r[idx]=r[k];
            l[r[k]]=idx;
            r[k]=idx;
            idx++;
        }

        static void delete(int k){
            l[r[k]]=l[k];
            r[l[k]]=r[k];
        }

        public static void main(String[]args)throws IOException {
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            int m=Integer.parseInt(in.readLine());

            init();
            while(m-->0){
                String[]arr=in.readLine().split(" ");
                String op=arr[0];

                if(op.equals("L")){
                    int x=Integer.parseInt(arr[1]);
                    add(0,x);
                }else if(op.equals("R")){
                    int x=Integer.parseInt(arr[1]);
                    add(l[1],x);
                }else if(op.equals("D")){
                    int k=Integer.parseInt(arr[1]);
                    delete(k+1);
                }else if(op.equals("IL")){
                    int k=Integer.parseInt(arr[1]);
                    int x=Integer.parseInt(arr[2]);
                    add(l[k+1],x);
                }else{
                    int k=Integer.parseInt(arr[1]);
                    int x=Integer.parseInt(arr[2]);
                    add(k+1,x);
                }
            }

            for(int i=r[0];i!=1;i=r[i]) System.out.print(e[i]+" ");
        }
    }
}
