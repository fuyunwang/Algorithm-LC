package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1306
 * @Author fyw
 * @Date 2022/11/14 21:55
 * @Description 跳跃游戏
 */
public class Code1306 {
    public boolean canReach(int[] arr, int start) {
        return dfs(arr,start);
    }
    // 检测是否能到达0
    boolean dfs(int[] arr,int u){
        if (arr[u]==0)
            return true;
        int[] pos=new int[]{u-arr[u],u+arr[u]};
        arr[u]=-1;  // 打标记表示已经访问过避免重复访问
        for (int x:pos){
            if (x>=0&&x<arr.length&&arr[x]!=-1){
                if (dfs(arr,x))
                    return true;
            }
        }
        return false;
    }
    // 记录步数
    int dfs_add(int[] arr,int u){
        if (arr[u]==0)
            return 1;
        int[] pos=new int[]{u-arr[u],u+arr[u]};
        arr[u]=-1;  // 打标记表示已经访问过避免重复访问
        int res=0;
        for (int x:pos){
            if (x>=0&&x<arr.length&&arr[x]!=-1){
                res+=dfs_add(arr,x);
            }
        }
        return res;
    }
}
