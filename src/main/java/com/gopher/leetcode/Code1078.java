package com.gopher.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code1078
 * @Author fyw
 * @Date 2022/2/6 10:18
 * @Description:
 */
public class Code1078 {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list=new ArrayList<>();
        String[] sp=text.split(" ");
        for(int i=0;i<sp.length-2;i++){
            if(sp[i].equals(first)&&sp[i+1].equals(second)){
                list.add(sp[i+2]);
            }
        }
        return list.toArray(new String[0]);
    }
}
