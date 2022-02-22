package com.gopher.interview;

import java.util.Stack;

/**
 * @Title Code29
 * @Author fyw
 * @Date 2022-02-22 10:57
 * @Description 城市游戏
 * LeetCode84 85
 */
public class Code29 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int n=matrix.length;int m=matrix[0].length;
        int[][] f=new int[n][m];        // f[i][j]表示(i,j)格子上方有多少个1，利用递推的方式计算
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j]=='1'){
                    if (i>0)
                        f[i][j]=1+f[i-1][j];
                    else{
                        f[i][j]=1;
                    }
                }
            }
        }
        int res=0;
        for (int i = 0; i < n; i++) {
            //枚举每一个下边界
            res=Math.max(res,largestRectangleArea(f[i]));
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int[] left=new int[heights.length+10];
        int[] right=new int[heights.length+10];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i]) stack.pop();
            if (stack.isEmpty())
                left[i]=-1;
            else
                left[i]=stack.peek();// 记录
            stack.push(i);
        }
        stack=new Stack<>();
        for (int i = heights.length-1; i >= 0; i--) {
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i]) stack.pop();
            if (stack.isEmpty())
                right[i]= heights.length;
            else
                right[i]=stack.peek();
            stack.push(i);
        }
        int res=Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            res=Math.max(res,heights[i]*(right[i]-left[i]-1)); // 右边第一个小和左边第一个小之间的差值作为宽，heights[i]作为高
        }
        return res;
    }
}
