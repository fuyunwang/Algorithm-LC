package com.gopher.coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title Big03
 * @Author fyw
 * @Date 2022/2/20 16:01
 * @Description:
 */
public class Big03 {
    static class Multi{
        // 将低精度b看成整体与高精度a相乘
        public static List<Integer> mul(List<Integer> a, int b) {
            List<Integer> c = new ArrayList<>();
            int t = 0;
            for (int i=0;i<a.size() || t != 0;i++) {
                if (i<a.size()) t+= a.get(i) *b;
                c.add(t % 10);
                t /= 10;
            }
            // 如果b是0，要清除前导0
            int n = c.size();
            while(c.size() > 1) {
                if(c.get(n-1) == 0) c.remove(n-1);
                else break;
                n = c.size();
            }
            return c;
        }

        public static void main(String[] args) {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            try {
                String a = buf.readLine();
                String b = buf.readLine();
                List<Integer> A = new ArrayList<>();
                int B = Integer.parseInt(b);
                for(int i=a.length()-1;i>=0;i--) {
                    A.add(a.charAt(i) - '0');
                }
                List<Integer> c = mul(A, B);
                for(int i=c.size()-1;i>=0;i--){
                    System.out.print(c.get(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
