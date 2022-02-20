package com.gopher.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Title Big04
 * @Author fyw
 * @Date 2022/2/20 16:01
 * @Description:
 */
public class Big04 {
    static class Div{
        static int t = 0; // 余数
        //从高位往低位除，得到商和余数，A/B
        public static List<Integer> div(List<Integer> A, int B)
        {
            for(int i = A.size() - 1;i >= 0 ;i--)
            {
                t = t * 10 + A.get(i);
                A.set(i, t / B);    //注意放到正确的位置
                t %= B;
            }
            while(A.size() > 1 && A.get(A.size() - 1) == 0) A.remove(A.size() - 1);// 去掉前导0
            return A;
        }
        public static void main(String[] args) {
            //传进一个字符串，一个数字
            Scanner scan = new Scanner(System.in);
            String a = scan.next();
            int B = scan.nextInt();

            List<Integer> A = new ArrayList<Integer>();
            for (int i = a.length() - 1; i >= 0; i -- ) A.add(a.charAt(i) - '0');
            List<Integer> C = div(A, B);

            for (int i = C.size() - 1; i >= 0; i -- ) System.out.print((C.get(i)));
            System.out.println();
            System.out.println(t);
        }

        static class Code2{
            public static List<Integer> div(List<Integer> A, int b) {
                List<Integer> C = new ArrayList<>();
                int r = 0;
                for(int i = A.size() - 1; i >= 0; i--) {
                    r = r * 10 + A.get(i);
                    C.add(r / b);
                    r %= b;
                }
                Collections.reverse(C);
                while(C.size() > 1 && C.get(C.size() - 1) == 0) C.remove(C.size() - 1);
                C.add(r);
                return C;
            }

            public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                char[] a = in.nextLine().toCharArray();
                int b = in.nextInt();
                List<Integer> A = new ArrayList<>(), C;
                for(int i = a.length - 1; i >= 0; i--) A.add(a[i] - '0');
                C = div(A, b);
                for(int i = C.size() - 2; i >= 0; i--) System.out.print(C.get(i));
                System.out.println();
                System.out.println(C.get(C.size() - 1));
            }
        }
    }

}
