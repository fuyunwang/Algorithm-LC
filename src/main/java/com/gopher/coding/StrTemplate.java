package com.gopher.coding;

import java.util.Scanner;

/**
 * @Title StrTemplate
 * @Author fyw
 * @Date 2022-03-03 19:54
 * @Description 字符串哈希
 */
public class StrTemplate {
        //开的是long类型数组，本来是需要进行前缀hash求完之后需要进行模2的64次方来防止相同的冲突，可能超过我们给的数组大小
        static int N = 100010,P = 131;//p是进制数，惊艳值
        static long[] h = new long[N];//这是存放hash前缀值得数组
        static long[] p = new long[N];//这是存放p的n次方的数组
        public static long get(int l,int r){//这里是将运用了一点前缀和公式的方式进行计算
            //求l-r区间的hash值，就要用h[r] - h[l-1],因为两者位数不用需要让h[l-1]向左边移到跟h[r]对齐
            //就比如求1234的3-4区间位，1234 - 12,12左移然后就让12*10^(4-3+1)=12*10^2=1200,然后1234-1200 = 34,这样进行计算出来
            //然后本题是p进制，所以需要将上面公式中的10换成p就行了
            //h[0] = 0
            //h[1] = h[i-1] * P + str[1] = 0*P+a = a
            //h[2] = a * P + b
            //h[3] = (a*P+b)*P+c = a*p[2]+b*P+c
            //h[4] = (a*p[2]+b*P+c)*P+d = a*p[3]+b*p[2]+c*P+d
            //比如abcd求3-4区间位，就是让h[d]-h[b]，h[b]位数不用需要向左移对齐h[d],
            //h[2]*P^(4-3+1)=(a*P+b)*P^2 = a*P^3+b*P^2
            //然后就让h[d] - h[b]求出34区间值,(a*p[3]+b*p[2]+c*P+d) - (a*P^3+b*P^2) = c*P+d
            return h[r] - h[l-1]*p[r-l+1];
        }
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            int m = scan.nextInt();
            String s = scan.next();
            p[0] = 1;//这个是p的0次方的值，需要单独写出来，非常重要
            for(int i = 1 ; i <= n ; i++ ){
                p[i] = p[i-1] * P;//这里对应每一个下标对应对应P的多少次方
                h[i] = h[i-1] * P + s.charAt(i-1);//这里是公式，预处理前缀哈希的值，因为是P进制，所以中间乘的是P
            }

            while(m -- > 0){
                int l1 = scan.nextInt();
                int r1 = scan.nextInt();
                int l2 = scan.nextInt();
                int r2 = scan.nextInt();
                //判断两个区间是不是相同,用get的方法返回值一样说明区间的hash值是一样的
                if(get(l1,r1) == get(l2,r2)) System.out.println("Yes");
                else System.out.println("No");
            }
        }

}
