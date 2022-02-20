package com.gopher.coding;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Title Big
 * @Author fyw
 * @Date 2022/2/20 15:39
 * @Description:
 */
public class Big {
    // big number是逆序存放到数组
    class Add{
        public void add1(){
            Scanner scanner = new Scanner(new BufferedInputStream(System.in));
            BigInteger a = scanner.nextBigInteger();
            BigInteger b = scanner.nextBigInteger();
            System.out.println(a.add(b));
            scanner.close();
        }
        class Code1{
            public List<Integer> add(List<Integer> A,List<Integer> B )
            {
                if (A.size()<B.size()) return add(B,A);
                int t = 0;
                for (int i = 0; i < A.size(); i ++ )
                {
                    t += A.get(i);
                    if (i < B.size()) t += B.get(i);
                    A.set(i, t % 10);
                    t /= 10;
                }
                if (t!=0) A.add(t);
                return A;
            }
            public void main(String[] args) {
                //传进两个字符串
                Scanner scan = new Scanner(System.in);
                String a = scan.next();
                String b = scan.next();

                List<Integer> A = new ArrayList<Integer>();
                List<Integer> B = new ArrayList<Integer>();
                for (int i = a.length() - 1; i >= 0; i -- ) A.add(a.charAt(i) - '0');
                for (int i = b.length() - 1; i >= 0; i -- ) B.add(b.charAt(i) - '0');

                List<Integer> C = add(A, B);
                for (int i = C.size() - 1; i >= 0; i -- ) System.out.print((C.get(i)));
            }
        }
        class Code2{
            public void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                String s1 = scanner.next();
                String s2 = scanner.next();
                List<Integer> A = new ArrayList<>(s1.length());
                List<Integer> B = new ArrayList<>(s2.length());
                for (int i = s1.length() - 1; i >= 0; i--) A.add(s1.charAt(i) - '0');
                for (int i = s2.length() - 1; i >= 0; i--) B.add(s2.charAt(i) - '0');
                List<Integer> C = add(A, B);
                for (int i = C.size() - 1; i >= 0; i--) System.out.printf(C.get(i) + "");
            }

            private List<Integer> add(List<Integer> A, List<Integer> B) {
                List<Integer>C=new ArrayList<>(Math.max(A.size(),B.size())+2);
                int t=0;
                for(int i=0;i<A.size() || i<B.size();i++){
                    if(i<A.size())t+=A.get(i);
                    if(i<B.size())t+=B.get(i);
                    C.add(t%10);
                    t/=10;
                }
                if(t!=0) C.add(t);
                return C;
            }
        }
    }
}
