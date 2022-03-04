package com.gopher.prac.leetcodeothers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title Code12222
 * @Author fyw
 * @Date 2022-03-04 19:40
 * @Description
 */
public class Code1222 {
    int[] dx=new int[]{-1,-1,0,1,1,1,0,-1};
    int[] dy=new int[]{0,1,1,1,0,-1,-1,-1};
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int x=king[0];
        int y=king[1];
        boolean[][] existed=new boolean[8][8];
        for (int i = 0; i < queens.length; i++) {
            existed[queens[i][0]][queens[i][1]]=true;       // 二维数组保存索引法
        }
        List<List<Integer>> res=new ArrayList<>();
        for (int j = 0; j < 8; j++) {
            int a=x+dx[j];
            int b=y+dy[j];
            while (a>=0&&a<8&&b>=0&&b<8){
                if (existed[a][b]){
                    List<Integer> temp=new ArrayList<>(Arrays.asList(a,b));
                    res.add(temp);
                    break;  // 直接终止，说明后续所有皇后都会被挡住
                }else{
                    a+=dx[j];   // 否则持续找
                    b+=dy[j];
                }
            }
        }
        return res;
    }
}