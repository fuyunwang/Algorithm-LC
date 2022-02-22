package com.gopher.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Title Code18
 * @Author fyw
 * @Date 2022-02-22 10:51
 * @Description 货仓选址
 * 绝对值不等式
 * 排序 取中位数
 */
public class Code18 {
    public static void main(String[] args) throws IOException {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String[] s=r.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        String[] line=r.readLine().split(" ");
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(line[i]);
        }
        int res=0;
        Arrays.sort(arr);
        // 取中位数作为货舱的选址地方
        for (int i = 0; i <n/2 ; i++) {
            res+=arr[n-i-1]-arr[i];
        }
        System.out.println(res);
    }
}
