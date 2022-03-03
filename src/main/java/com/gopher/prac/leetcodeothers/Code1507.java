package com.gopher.prac.leetcodeothers;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code1507
 * @Author fyw
 * @Date 2022-03-03 19:14
 * @Description
 */
public class Code1507 {
    public String reformatDate(String date) {
        StringBuilder sb=new StringBuilder();
        Map<String,String> map=new HashMap<String,String>(){
            {
                put("Jan","01");
                put("Feb","02");
                put("Mar","03");
                put("Apr","04");
                put("May","05");
                put("Jun","06");
                put("Jul","07");
                put("Aug","08");
                put("Sep","09");
                put("Oct","10");
                put("Nov","11");
                put("Dec","12");
            }
        };
        int cnt=0;
        for (int i = date.length()-1; i >= 0 ; i--) {
            int j=i;
            while (j>=0&&date.charAt(j)!=' '){
                j++;

            }
            if (cnt==1){
                sb.append(map.get(date.substring(j+1,i+1))).append('-');
            }else if (cnt==0){
                sb.append(date.substring(j+1)).append('-');
            }else{
                String cur=date.substring(j,i+1);
                if (cur.length()<4){
                    cur="0" + cur.substring(j,j+1);
                }else{
                    cur=cur.substring(j,j+2);
                }
                sb.append(cur);
            }
            cnt++;

            i=j;
        }
        return sb.toString();
    }
}
