package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1601
 * @Author fyw
 * @Date 2022-02-28 15:54
 * @Description 最多可达成的换楼请求数目
 */
public class Code1601 {
    int result=0,count=0;// result记录结果,count记录每次尝试的结果
    int flag;           // 标记位表示目前有多少个楼处于初始状态，即0
    int[] delta;        // 记录每个楼的状态，开始都是空的，最后也需要全是空的才能满足条件
    public int maximumRequests(int n, int[][] requests) {
        flag=delta.length;
        delta=new int[n];
        backtrack(requests,0);  // 第二个参数表示要考虑的第pos个请求
        return result;
    }

    public void backtrack(int[][] request,int pos){
        if (pos==request.length){
            if (flag==delta.length){                  // 初始状态仍保持，说明是当前请求的变化是合适的
                result=Math.max(result,count);
            }
            return;
        }
        backtrack(request,pos+1);       // pos请求不考虑
        // pos请求考虑
        count++;
        int origin=flag;
        int[] curRequest=request[pos];
        int leave=curRequest[0], come=curRequest[1];    // 当前请求的原处楼和要离开的去向
        flag-=delta[leave]==0?1:0;                      // 变化，如果对应楼本来状态是初始状态，进行了改变需要记录下
        --delta[leave];
        flag+=delta[leave]==0?1:0;                      // 变化，如果一个请求导致当前多了一个初始状态，进行了改变需要记录下
        flag-=delta[come]==0?1:0;                       // 变化，如果对应楼本来状态是初始状态，进行了改变需要记录下
        ++delta[come];
        flag+=delta[come]==0?1:0;                       // 变化，如果一个请求导致当前多了一个初始状态，进行了改变需要记录下
        backtrack(request,pos+1);
        // 恢复现场
        --delta[come];
        ++delta[leave];
        flag=origin;
        --count;
    }
}
