package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1108
 * @Author fyw
 * @Date 2022/1/25 8:58
 * @Description: 水题，IP地址无效化
 */
public class Code1108 {
    public String defangIPaddr(String address) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<address.length();i++){
            if(address.charAt(i)=='.'){
                sb.append("[.]");
            }else{
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }
}
