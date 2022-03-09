package com.gopher.leetcode.types.simulation;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @Title BitCalculate
 * @Author fyw
 * @Date 2022-03-05 19:56
 * @Description 位运算
 */
public class BitCalculate {
    static class Code1017{
        // 负二进制转换
        // 短除法
        public String baseNeg2(int N) {
            // java和除法运算与模运算是取绝对值做运算，然后加个负号。所以，不能直接用java的 / 运算符，偶数不用管，直接除，奇数的话，先减去1，再做除运算。
            // 大佬说了是因为java的负数除法不能直接用 比如 java中-3/-2 得 1 余 1，但是 -2 × 1 + 1 = -1 而不等于-3 正确的关系应该满足 （商 × -2) + 1 = 被除数，所以 商 = （被除数 - 1）/ -2 即 N = (N-1)/-2
            if(N == 0)
                return "0";
            String result = "";
            int n = N;
            while(n != 0){
                if(n % 2 == 0){//与n%(-2)只差一个符号关系，如果是0就是说这一位为0，符号关系自然也就不用考虑了
                    result = "0" + result;
                    n = n / (-2);
                }else {
                    result = "1" + result;
                    n = (n - 1) / (-2);
                }
            }
            return result;
        }
    }
    static class Code1009{
        // 求n的第k位 ： n>>k&1
        // 1<<i 表示2的i次方
        public int bitwiseComplement(int n) {
            if (n == 0) return 1;
            int res = 0;
            for (int i = 0; 1 << i <= n; i ++){
                res ^= ((n >> i & 1) == 1 ? 0 : 1) << i;
            }
            return res;
        }
    }
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res=new ArrayList<>();
        while (label>0){
            res.add(label);
            label>>=1;
        }
        Collections.reverse(res);
        // 对于指定位置异或全1，即2^i-1
        for (int i=res.size()&1;i<res.size();i+=2){
            res.set(i,res.get(i)^((1<<i)-1));
        }
        return res;
    }
    static class Code1290{
        // 二进制链表（二进制转10进制）转整数
        public int getDecimalValue(ListNode head) {
            if(head==null){
                return 0;
            }
            int res=0;
            while(head!=null){
                res=(res<<1)+head.val;
                head=head.next;
            }
            return res;
        }
    }
    static class Code762{
        class Solution {
            public int countPrimeSetBits(int left, int right) {
                // 最大范围是2^19
                HashSet<Integer> primes=new HashSet<>();
                primes.add(2);
                primes.add(3);
                primes.add(5);
                primes.add(7);
                primes.add(11);
                primes.add(13);
                primes.add(17);
                primes.add(19);
                int res=0;
                while (left<=right){
                    int cur=0;
                    for (int i = left; i > 0; i>>=1) {
                        cur+=(i&1);
                    }
                    if (primes.contains(cur)){
                        res++;
                    }
                    left++;
                }
                return res;
            }
        }
    }
    static class Code504{
        // 十进制转7进制
//        public String convertToBase7(int num) {
//            return Integer.toString(num,7);
//        }
        public String convertToBase7(int num) {
            if(num == 0) return "0";
            StringBuilder sb=new StringBuilder();
            boolean flag=num<0;
            num=Math.abs(num);
            while (num!=0){
                sb.insert(0,num%7);
                num/=7;
            }
            if (flag)
                sb.insert(0,'-');
            return sb.toString();
        }

        /*
         * public String convertToBase7(int num) {
         *         if(num<0){
         *             return "-"+convertToBase7(-1*num);
         *         }
         *         if(num<7){
         *             return ""+num;
         *         }
         *         return convertToBase7(num/7)+String.valueOf(num%7);
         * }
         */
    }
}
