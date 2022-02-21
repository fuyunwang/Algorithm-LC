package com.gopher.coding;

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
}
