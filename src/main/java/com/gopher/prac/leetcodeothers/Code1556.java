package com.gopher.prac.leetcodeothers;

/**
 * @Title Code1556
 * @Author fyw
 * @Date 2022-02-25 16:52
 * @Description 千分位分割
 */
public class Code1556 {
    public String thousandSeparator(int n) {
        StringBuffer sb = new StringBuffer(String.valueOf(n));
        for (int i = sb.length() - 3; i > 0; i -= 3) sb.insert(i, '.');// 插入到索引i的位置然后其他的数往后移动
        return sb.toString();
    }
}
