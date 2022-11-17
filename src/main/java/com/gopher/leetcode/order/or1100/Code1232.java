package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1232
 * @Author fyw
 * @Date 2022/11/17 21:21
 * @Description 缀点成线
 * 本质是判断多点共线
 * 三点及以上共线采用 三角形面积为0判断，即求叉积
 */
public class Code1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 2; i < coordinates.length; i++) {
            int x1=coordinates[1][0]-coordinates[0][0];
            int y1=coordinates[1][1]-coordinates[0][1];
            int x2=coordinates[i][0]-coordinates[0][0];
            int y2=coordinates[i][1]-coordinates[0][1];
            if (x1*y2-x2*y1!=0)
                return false;
        }
        return true;
    }
}
