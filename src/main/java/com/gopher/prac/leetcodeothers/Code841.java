package com.gopher.prac.leetcodeothers;

import java.util.List;

/**
 * @Title Code841
 * @Author fyw
 * @Date 2022-03-07 16:35
 * @Description
 */
public class Code841 {
    boolean[] visited;
    List<List<Integer>> houses;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited=new boolean[rooms.size()];
        this.houses=rooms;
        dfs(0);
        boolean flag=false;
        for (boolean v:visited){
            if (!v)
                flag=true;
        }
        return !flag;
    }
    void dfs(int index){
        if (index>houses.size()||visited[index])
            return;
        visited[index]=true;
        List<Integer> list = houses.get(index);
        for (int i = 0; i < list.size(); i++) {
            dfs(list.get(i));
        }
    }
}
