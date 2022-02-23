package com.gopher.leetcode.order.or120;

/**
 * @Title Code171
 * @Author fyw
 * @Date 2022/2/9 14:49
 * @Description: Excel 表列序号
 *  10进制到26进制的转换，逆向
 */
public class Code171 {
    public int titleToNumber(String columnTitle) {
        int res=0;
        for (int i=0; i<columnTitle.length(); i++) {
            res=res*26+(columnTitle.charAt(i)-'A'+1);
        }
        return res;
    }
}
