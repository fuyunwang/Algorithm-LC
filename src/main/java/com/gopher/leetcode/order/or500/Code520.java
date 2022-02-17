package com.gopher.leetcode.order.or500;

/**
 * @Title Code520
 * @Author fyw
 * @Date 2022/2/8 21:06
 * @Description: 检测大写字母
 */
public class Code520 {
    /**
     * 思路是考虑字符串中大写字母的个数
     * 如果是等于字符串长度则为正确，
     * 如果个数为1且为首字母则正确
     * 如果个数为0则为正确
     * 其他的都不正确
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        int count=0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i)>='A'&&word.charAt(i)<='Z'){
                count++;
            }
        }
        if (count==0)
            return true;
        if (count==word.length()){
            return true;
        }
        if (count==1&&word.charAt(0)>='A'&&word.charAt(0)<='Z')
            return true;
        return false;
    }
}
