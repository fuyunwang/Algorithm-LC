package com.gopher.leetcode.order.or120;

/**
 * @Title Code165
 * @Author fyw
 * @Date 2022/2/8 21:19
 * @Description: 比较版本号
 * 简单题
 */
public class Code165 {
    public int compareVersion(String version1, String version2) {
        for (int i = 0,j=0; i < version1.length()||j<version2.length(); i++,j++) {
            int a=i;
            int b=j;
            while (a<version1.length()&&version1.charAt(a)!='.') a++;
            while (b<version2.length()&&version2.charAt(b)!='.') b++;
            int x=a==i?0:Integer.parseInt(version1.substring(i,a));
            int y=b==j?0:Integer.parseInt(version2.substring(j,b));
            if (x>y)
                return 1;
            if (x<y)
                return -1;
            i=a;
            j=b;
        }
        return 0;
    }
}
