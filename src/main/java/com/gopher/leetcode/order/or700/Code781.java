package com.gopher.leetcode.order.or700;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code781
 * @Author fyw
 * @Date 2022/2/17 12:46
 * @Description: 森林中的兔子
 * 脑筋急转弯
 */
public class Code781 {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        for (int answer: answers){
            if (map.containsKey(answer)&&map.get(answer)>0){
                map.put(answer,map.get(answer)-1);
            }else{
                res+=answer+1;
                map.put(answer,answer);
            }
        }
        return res;
    }
}
