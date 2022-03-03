package com.gopher.prac.leetcodeothers;

/**
 * @Title Code1854
 * @Author fyw
 * @Date 2022-03-03 15:47
 * @Description 人口最多的年份
 * 差分数组
 */
public class Code1854 {
    public int maximumPopulation(int[][] logs) {
        int count=1;
        int temp=1;
        int res=logs[0][0];
        boolean flag=false;
        for (int i = 0; i < logs.length; i++) {
            int j=i+1;
            if (j<logs.length&&logs[j][0]<logs[i][1]){
                count++;
                if (count>temp&&!flag){
                    temp=count;
                    res=logs[j][0];
                    flag=true;
                }
            }else if (j<logs.length&&logs[j][0]>logs[i][1]){
                // 严格大于
                count=1;
                flag=false;
            }

        }
        return res;
    }
}
