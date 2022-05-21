package com.fuyunwang.bilibili.order.doublepointer;

/**
 * @Title Code38
 * @Author fyw
 * @Date 2022/5/21 16:55
 * @Description: 外观数列，双指针模板题
 */
public class Code38 {
    public String countAndSay(int n) {
        String t="1";
        // 循环n-1次
        for (int i = 0; i < n-1; i++) {
            // 当前轮形成的状态
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < t.length();) {
                int k=j+1;
                while (k<t.length()&&t.charAt(k)==t.charAt(j))
                    k++;
                sb.append(k-j).append(t.charAt(j));
                j=k;
            }
            t=sb.toString();
        }
        return t;
    }
}
