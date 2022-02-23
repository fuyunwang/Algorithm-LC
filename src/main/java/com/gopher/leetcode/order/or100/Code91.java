package com.gopher.leetcode.order.or100;

/**
 * @Title Code91
 * @Author fyw
 * @Date 2022/2/8 22:01
 * @Description: 解码方法
 * 使用字母编码得到的数字串解码出可能的字符组合
 * dp
 */
public class Code91 {
    // f[i]表示所有由前i个字符可以解码回去的字符串的集合，属性为个数
    // f[i]分成多个子集，分类讨论。考虑最后一种字符一位还是两位
    public int numDecodings(String s) {
        s = " " + s;
        int n=s.length();
        int[] f=new int[n];

        f[0]=1;// 没有字符算解码出一种情况
        for (int i = 1; i < n; i++) {
            if (s.charAt(i)>='1'&&s.charAt(i)<='9')
                f[i]=f[i-1];
            if (i>1){
                int t=(s.charAt(i-1)-'0')*10+(s.charAt(i)-'0');
                if (t>=10&&t<=26)
                    f[i]+=f[i-2];
            }
        }
        return f[n-1];
    }

}
