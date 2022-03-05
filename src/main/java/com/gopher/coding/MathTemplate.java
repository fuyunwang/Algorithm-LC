package com.gopher.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Title Math
 * @Author fyw
 * @Date 2022-03-05 16:16
 * @Description
 */
public class MathTemplate {
    static class Code1{
        // 快速幂
        // a^k % p

        static int qmi(int a, int b, int p){
            int res = 1%p; //防止p为1

            while(b>0){
                if(b%2==1) res = (int)((long)res*a%p);
                a = (int)((long)a*a%p);
                b/=2;
            }
            return res;
        }

        public static void main(String[] args)throws IOException {
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            int n=Integer.parseInt(in.readLine());

            while(n-->0){
                String[] arr=in.readLine().split(" ");
                int a=Integer.parseInt(arr[0]);
                int b=Integer.parseInt(arr[1]);
                int p=Integer.parseInt(arr[2]);

                System.out.println(qmi(a,b,p));
            }
        }
    }
}
