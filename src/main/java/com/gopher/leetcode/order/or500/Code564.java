package com.gopher.leetcode.order.or500;

import java.util.HashSet;

/**
 * @Title Code564
 * @Author fyw
 * @Date 2022-03-02 14:37
 * @Description 寻找最近的回文数
 * 字节三面
 */
public class Code564 {
    public String nearestPalindromic(String n) {
        int len=n.length();
        HashSet<Long> set=new HashSet<>();
        // 注意边界特判，1001的左边界是999，9999的右边界是1001
        set.add((long) (Math.pow(10,len)+1));
        set.add((long) (Math.pow(10,len-1)-1));
        // 取n的前半位
        Long mid=Long.parseLong(n.substring(0,(len+1)/2));
        for (int i = -1; i <= 1; i++) {
            Long val=mid+i;
            String cur=String.valueOf(val);
            if (len%2!=0){
                //奇数
                cur=cur+new StringBuilder(cur.substring(0,cur.length()-1)).reverse();
            }else{
                cur=cur+new StringBuilder(cur).reverse();
            }
            set.add(Long.parseLong(cur));
        }
        long nVal=Long.parseLong(n);
        if (set.contains(nVal))
            set.remove(nVal);
        long res= (long) 2e18;
        long cha= (long) (1e18+1);
        for(Long l:set){
            if (Math.abs(res-nVal)>Math.abs(l-nVal)){
                res=l;
                cha=Math.abs(l-nVal);   // 记录差值
            }else if (cha==Math.abs(l-nVal)){
                if (l<res){
                    res=l;
                }
            }
        }
        return String.valueOf(res);
    }
}
