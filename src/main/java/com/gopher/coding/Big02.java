package com.gopher.coding;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Title Big02
 * @Author fyw
 * @Date 2022/2/20 16:01
 * @Description:
 */
public class Big02 {
    static class Reduction{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String a = scanner.next();
            String b = scanner.next();
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            for(int i = a.length()-1;i>=0;i--) A.add(a.charAt(i)-'0');
            for(int i = b.length()-1;i>=0;i--) B.add(b.charAt(i)-'0');

            if(!check(A, B)) System.out.print("-");// 检查大小，结果由此为正为负
            A = sub(A, B);

            for(int i = A.size()-1;i>=0;i--) {
                System.out.print(A.get(i));
            }
        }
        // 减法 A-B
        private static ArrayList<Integer> sub(ArrayList<Integer> A, ArrayList<Integer> B) {
            if(!check(A,B)) {
                return sub(B, A);
            }
            int t = 0;
            for(int i = 0;i<A.size();i++) {
                t=A.get(i)-t;
                if(i < B.size()) t-=B.get(i);
                A.set(i, (t+10)%10);    // 分为t>=0和t<0两种情况
                if(t<0) t = 1;
                else t = 0;
            }
            while(A.size()>1&&A.get(A.size()-1)==0) // 去掉前导0
                A.remove(A.size()-1);
            return A;
        }
        // 判断a和b的大小
        private static boolean check(ArrayList<Integer> a, ArrayList<Integer> b) {
            if(a.size()>b.size()) return true;
            else if(b.size()>a.size()) return false;
            else {
                for(int i = a.size()-1;i>=0;i--) {
                    if(!a.get(i).equals(b.get(i))) {
                        return a.get(i)>b.get(i);
                    }
                }
            }
            return true;
        }
    }
}
