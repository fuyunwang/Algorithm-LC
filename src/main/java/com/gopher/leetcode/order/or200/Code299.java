package com.gopher.leetcode.order.or200;

import java.util.HashMap;

/**
 * @Title Code299
 * @Author fyw
 * @Date 2022/2/9 14:06
 * @Description: 猜数字游戏
 * 求对应位置相同字符的有多少情况；求不看位置的相同字符有多少情况
 */
public class Code299 {
    public String getHint(String secret, String guess) {
        int res1=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i)==guess.charAt(i)){
                res1++;
            }
            map.put(secret.charAt(i),map.getOrDefault(secret.charAt(i),0)+1);
        }
        StringBuilder sb=new StringBuilder();
        sb.append(res1).append("A");
        int res2=0;
        for (int i = 0; i < guess.length(); i++) {
            if (map.containsKey(guess.charAt(i))&&map.get(guess.charAt(i))>0){
                res2++;
                map.put(guess.charAt(i),map.get(guess.charAt(i))-1);
            }
        }
        sb.append(res2-res1).append("B");
        return sb.toString();
    }
}
