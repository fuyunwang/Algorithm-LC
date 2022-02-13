package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1189
 * @Author fyw
 * @Date 2022/2/13 14:10
 * @Description:
 */
public class Code1189 {
    public int maxNumberOfBalloons(String text) {
        String target="balloon";
        final char[] chars = text.toCharArray();
        int[] temp=new int[26];
        for (int i = 0; i < chars.length; i++) {
            temp[chars[i]-'a']++;
        }
        int res=0;
        while (true){
            int i = 0;
            for (;i < target.length(); i++) {
                char c = target.charAt(i);
                final int i1 = temp[c - 'a'];
                if (i1>0){
                    temp[c-'a']--;
                }else{
                    break;
                }
            }
            if (i==target.length()){
                res++;
            }else{
                break;
            }
        }
        return res;
    }

}
