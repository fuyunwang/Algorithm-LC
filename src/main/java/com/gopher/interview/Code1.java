package com.gopher.interview;

import java.util.Scanner;

/**
 * @Title Code1
 * @Author fyw
 * @Date 2022/1/30 12:41
 * @Description: 螺旋矩阵，蛇形打印，转圈打印
 */
public class Code1 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();
        int m=scanner.nextInt();

        int[][] matrix=new int[n][m];

        int[] dx=new int[]{-1,0,1,0};

        int[] dy=new int[]{0,1,0,-1};

        for (int i=0,j=0,d=0,k=1; i<n&&j<m ; i++,j++,k++){
            matrix[i][j]=k;
            int x=i+dx[d];
            int y=j+dy[d];
            if(x<0||x>=n||y<0||y>=m||matrix[x][y]>0){
                d=(d+1)%4;
                x=i+dx[d];
                y=i+dy[d];
            }
            i=x;
            j=y;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
