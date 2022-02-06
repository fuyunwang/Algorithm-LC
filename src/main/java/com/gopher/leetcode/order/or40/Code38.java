package com.gopher.leetcode.order.or40;

/**
 * @Title Code38
 * @Author fyw
 * @Date 2022/1/27 19:56
 * @Description:
 */
public class Code38 {
    public String countAndSay(int n) {
        String res="1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < res.length();) {
                int k=j+1;
                while (k<res.length()&&res.charAt(k)==res.charAt(j)) k++;
                sb.append(k-j).append(res.charAt(j));
                j=k;
            }
            res=sb.toString();
        }
        return res;
    }
}
