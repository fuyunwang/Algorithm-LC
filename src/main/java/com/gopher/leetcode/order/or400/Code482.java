package com.gopher.leetcode.order.or400;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code482
 * @Author fyw
 * @Date 2022/2/13 19:27
 * @Description: 密钥格式化
 */
public class Code482 {
    public String licenseKeyFormatting(String s, int k) {
        List<String> temp=new ArrayList<>();
        s=s.replaceAll("-","").toUpperCase();
        for (int j = s.length()-1; j >=0 ; j-=k) {
            if (j<k){
                //将指定的元素插入到列表的指定位置(可选操作)。将当前位置的元素(如果有的话)和随后的元素向右移动(给它们的下标加1)。
                temp.add(0,s.substring(0,j+1));
                break;
            }
            temp.add(0,"-"+s.substring(j-k+1,j+1));
        }
        StringBuilder sb=new StringBuilder();
        for (String t:temp){
            sb.append(t);
        }
        return sb.toString();
    }
}
