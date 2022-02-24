package com.gopher.leetcode.order.or400;

/**
 * @Title Code405
 * @Author fyw
 * @Date 2022/2/9 14:08
 * @Description: 数字转换为十六进制数
 */
public class Code405 {
    // int 转 16进制，32位 4位一组
    public String toHex(int num) {
        //分成8组，每组4位  （取4位，删除4位）
        if(num==0) return "0";
        String hex = "0123456789abcdef";
        StringBuilder sb = new StringBuilder();
        while(num!=0){
            sb.append(hex.charAt(num&0xf));
            num>>>=4;  //无符号右移
        }
        return sb.reverse().toString();
    }

}
