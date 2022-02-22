package com.gopher.interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Title Code87
 * @Author fyw
 * @Date 2022-02-22 11:18
 * @Description 蒙斯特
 * 插入排序
 */
public class Code87 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = 110;
        String[] cards = new String[N];
        int T = Integer.parseInt(in.readLine());
        for (int cases = 1; cases <= T; cases ++) {
            // 初始化
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n; i ++) {
                cards[i] = in.readLine();
            }

            int res = 0;
            for (int i = 1; i < n; i ++) {
                if (cards[i].compareTo(cards[i - 1]) < 0) {
                    for (int j = i; j > 0; j --) {
                        if (cards[j].compareTo(cards[j - 1]) < 0) {
                            String temp = cards[j];
                            cards[j] = cards[j - 1];
                            cards[j - 1] = temp;
                        }
                    }
                    res ++;
                }
            }
            System.out.printf("Case #%d: %d\n", cases, res);
        }
    }
}
